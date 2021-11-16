package au.com.nvc.loganalyser.data;

public class Result {
    private int uniqueIpAddress;
    private String[] mostVisitedUrls;
    private String[] mostActiveAddresses;

    public int getUniqueIpAddress() {
        return uniqueIpAddress;
    }

    public void setUniqueIpAddress(int uniqueIpAddress) {
        this.uniqueIpAddress = uniqueIpAddress;
    }

    public String[] getMostVisitedUrls() {
        return mostVisitedUrls;
    }

    public void setMostVisitedUrls(String[] mostVisitedUrls) {
        this.mostVisitedUrls = mostVisitedUrls;
    }

    public String[] getMostActiveAddresses() {
        return mostActiveAddresses;
    }

    public void setMostActiveAddresses(String[] mostActiveAddresses) {
        this.mostActiveAddresses = mostActiveAddresses;
    }
}
