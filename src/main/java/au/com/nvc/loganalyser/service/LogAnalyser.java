package au.com.nvc.loganalyser.service;

import au.com.nvc.loganalyser.data.Result;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LogAnalyser {

    private static final String LOG_FILE = "logs/programming-task-example-data.log";

    public Result process() throws IOException {
        final String regex = "^(\\S+) (\\S+) (\\S+) " +
                "\\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(\\S+)" +
                " (\\S+)\\s*(\\S+)?\\s*\" (\\d{3}) (\\S+)";
        final Pattern pattern = Pattern.compile(regex);
        InputStream resource = new ClassPathResource(LOG_FILE).getInputStream();
        Map<String, Integer> ipAddresses = new HashMap<>();
        Map<String, Integer> sites = new HashMap<>();
        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(resource)) ) {
            reader.lines().forEach(
                line -> {
                    final Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        ipAddresses.compute(matcher.group(1), (k, v) -> (v == null) ? 1 : v+1);
                        sites.compute(matcher.group(6), (k, v) -> (v == null) ? 1 : v+1);
                    }
                }
            );
        }
        Result result = new Result();
        result.setUniqueIpAddress(ipAddresses.size());
        System.out.println("Active IP Addresses "+ipAddresses+" sites "+sites);
        return result;
    }
}
