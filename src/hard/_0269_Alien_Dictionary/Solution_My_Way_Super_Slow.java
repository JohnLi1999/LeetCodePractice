package hard._0269_Alien_Dictionary;

import java.util.*;

public class Solution_My_Way_Super_Slow {
    public String alienOrder(String[] words) {
        if (checkPrefixAndDuplicates(words)) {
            return "";
        }

        List<StringBuilder> results = new ArrayList<>();

        Deque<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(words));

        while (!queue.isEmpty()) {
            List<String> toSearch = queue.poll();
            List<String> candidate = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            char prev = '#';
            for (int i = 0; i < toSearch.size(); i++) {
                String s = toSearch.get(i);
                char c = s.charAt(0);

                if (c == prev) {
                    if (!s.substring(1).isEmpty()) {
                        candidate.add(s.substring(1));
                    }
                } else {
                    if (result.indexOf(c + "") != -1) {
                        return "";
                    }

                    if (candidate.size() > 1) {
                        queue.add(new ArrayList<>(candidate));
                        candidate.clear();
                    }

                    if (i != toSearch.size() - 1 && c != toSearch.get(i + 1).charAt(0)) {
                        prev = c;
                        result.append(c);
                        if (!s.substring(1).isEmpty()) {
                            queue.add(List.of(s.substring(1)));
                        }
                    }

                    if (i == toSearch.size() - 1 || c == toSearch.get(i + 1).charAt(0)) {
                        prev = c;
                        result.append(c);
                        if (!s.substring(1).isEmpty()) {
                            candidate.add(s.substring(1));
                        }
                    }
                }
            }

            if (candidate.size() > 0) {
                queue.add(new ArrayList<>(candidate));
                candidate.clear();
            }

            if (result.length() > 1 || result.length() == 1 && !containsChar(result.charAt(0), results)) {
                results.add(result);
            }
        }

        return mergeResults(results);
    }

    private boolean checkPrefixAndDuplicates(String[] words) {
        List<StringBuilder> list = new ArrayList<>();
        for (String word : words) {
            list.add(new StringBuilder(word));
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).indexOf(list.get(j).toString()) == 0 && list.get(i).compareTo(list.get(j)) != 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private String mergeResults(List<StringBuilder> results) {
        if (results.isEmpty()) {
            return "";
        }

        List<StringBuilder> resultsWithoutDuplicate = new ArrayList<>();

        for (StringBuilder sb1 : results) {
            boolean unique = true;

            for (StringBuilder sb2 : results) {
                if (sb1 != sb2 && sb2.indexOf(sb1.toString()) != -1) {
                    if (sb1.compareTo(sb2) == 0 && !resultsWithoutDuplicate.contains(sb1) && !resultsWithoutDuplicate.contains(sb2)) {
                        continue;
                    }

                    unique = false;
                    break;
                }
            }

            if (unique) {
                resultsWithoutDuplicate.add(sb1);
            }
        }

        StringBuilder finalResult = new StringBuilder(resultsWithoutDuplicate.get(0));

        for (int i = 1; i < resultsWithoutDuplicate.size(); i++) {
            StringBuilder sb = resultsWithoutDuplicate.get(i);
            char[] resultChars = finalResult.toString().toCharArray();
            int maxIndex = -1;

            for (char c : resultChars) {
                int index = sb.indexOf(c + "");

                if (index != -1 && index > maxIndex) {
                    int finalResultIndex = finalResult.indexOf(c + "");
                    finalResult.insert(finalResultIndex, sb.substring(maxIndex + 1, index));
                    maxIndex = index;
                }
            }

            finalResult.append(sb.substring(maxIndex + 1));
        }

        for (int i = 0; i < finalResult.length(); i++) {
            char c = finalResult.charAt(i);

            if (i != finalResult.lastIndexOf(c + "")) {
                return "";
            }
        }

        return finalResult.toString();
    }

    private boolean containsChar(char c, List<StringBuilder> results) {
        for (StringBuilder sb : results) {
            if (sb.indexOf(c + "") != -1) {
                return true;
            }
        }
        return false;
    }
}
