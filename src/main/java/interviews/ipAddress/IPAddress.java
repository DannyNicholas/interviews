package interviews.ipAddress;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Find which IP address in a log file occurs most frequently.
 */
public class IPAddress {

    private static final Pattern IP_PATTERN = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");

    private static Optional<String> getIpAddress(String input){
        Matcher ipMatcher = IP_PATTERN.matcher(input);
        if(ipMatcher.find()){
            return Optional.of(ipMatcher.group(0));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {

        // holds IP addresses in order they were seen
        List<String> ipAddressList = Arrays.stream(logArray()).map(s -> getIpAddress(s).get()).collect(Collectors.toList());

        // holds map of counts per IP address
        Map<String, Long> ipCount = ipAddressList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        // map holding list of IP addresses against frequency seen
        Map<Long, List<String>> ipForCounts = new HashMap<>();

        // find highest count in the map
        Long highestCount = null;
        for (String ipAddress : ipAddressList) {

            // frequency of this IP address
            Long count = ipCount.get(ipAddress);

            // add to list of IP addresses seen
            final List<String> ipAddresses = ipForCounts.getOrDefault(count, new ArrayList<>());
            ipAddresses.add(ipAddress);
            ipForCounts.put(count, ipAddresses);

            // is this highest count seen so far?
            if (highestCount == null || count > highestCount) {
                highestCount = count;
            }
        }

        System.out.println(ipForCounts);
        System.out.println("First highest IP seen: " + ipForCounts.get(highestCount).get(0));
    }

    private static String[] logArray() {
        String[] arrays = new String[] {
                "10.0.0.1 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "10.0.0.2 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "10.0.0.1 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "10.0.0.2 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "10.0.0.3 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit"
        };

        return arrays;
    }
}
