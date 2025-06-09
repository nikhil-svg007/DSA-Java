### 1. Maximum Average Subarray I (Easy)
```java
public double findMaxAverage(int[] nums, int k) {
    double max = 0, sum = 0;
    for (int i = 0; i < k; i++) sum += nums[i];
    max = sum;
    for (int i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k];
        max = Math.max(max, sum);
    }
    return max / k;
}
```

### 2. Minimum Size Subarray Sum (Medium)
```java
public int minSubArrayLen(int target, int[] nums) {
    int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left++];
        }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
```

### 3. Longest Substring Without Repeating Characters (Medium)
```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, max = 0;
    for (int right = 0; right < s.length(); right++) {
        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left++));
        }
        set.add(s.charAt(right));
        max = Math.max(max, right - left + 1);
    }
    return max;
}
```

### 4. Permutation in String (Medium)
```java
public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    int[] s1map = new int[26];
    int[] s2map = new int[26];

    for (int i = 0; i < s1.length(); i++) {
        s1map[s1.charAt(i) - 'a']++;
        s2map[s2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length() - s1.length(); i++) {
        if (Arrays.equals(s1map, s2map)) return true;
        s2map[s2.charAt(i + s1.length()) - 'a']++;
        s2map[s2.charAt(i) - 'a']--;
    }
    return Arrays.equals(s1map, s2map);
}
```

### 5. Find All Anagrams in a String (Medium)
```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if (s.length() < p.length()) return res;

    int[] pCount = new int[26];
    int[] sCount = new int[26];

    for (int i = 0; i < p.length(); i++) {
        pCount[p.charAt(i) - 'a']++;
        sCount[s.charAt(i) - 'a']++;
    }

    if (Arrays.equals(pCount, sCount)) res.add(0);

    for (int i = p.length(); i < s.length(); i++) {
        sCount[s.charAt(i) - 'a']++;
        sCount[s.charAt(i - p.length()) - 'a']--;
        if (Arrays.equals(pCount, sCount)) res.add(i - p.length() + 1);
    }

    return res;
}
```

### 6. Sliding Window Maximum (Hard)
```java
public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) return new int[0];
    int[] res = new int[nums.length - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {
        if (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
        dq.offer(i);
        if (i >= k - 1) res[i - k + 1] = nums[dq.peek()];
    }

    return res;
}
```

### 7. Longest Repeating Character Replacement (Medium)
```java
public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int left = 0, maxCount = 0, maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        count[s.charAt(right) - 'A']++;
        maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

        while (right - left + 1 - maxCount > k) {
            count[s.charAt(left) - 'A']--;
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}
```

### 8. Count Number of Nice Subarrays (Medium)
```java
public int numberOfSubarrays(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) nums[i] %= 2;
    Map<Integer, Integer> count = new HashMap<>();
    count.put(0, 1);
    int prefix = 0, res = 0;

    for (int n : nums) {
        prefix += n;
        res += count.getOrDefault(prefix - k, 0);
        count.put(prefix, count.getOrDefault(prefix, 0) + 1);
    }

    return res;
}
```

### 9. Longest Substring with At Most K Distinct Characters (Medium)
```java
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

        while (map.size() > k) {
            char ch = s.charAt(left);
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) map.remove(ch);
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

### 10. Substring with Concatenation of All Words (Hard)
```java
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (words.length == 0 || s.length() < words.length * words[0].length()) return result;

    int wordLen = words[0].length();
    int totalLen = wordLen * words.length;
    Map<String, Integer> wordCount = new HashMap<>();

    for (String word : words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

    for (int i = 0; i < wordLen; i++) {
        int left = i;
        int count = 0;
        Map<String, Integer> seen = new HashMap<>();

        for (int j = i; j <= s.length() - wordLen; j += wordLen) {
            String word = s.substring(j, j + wordLen);
            if (wordCount.containsKey(word)) {
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while (seen.get(word) > wordCount.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == words.length) result.add(left);
            } else {
                seen.clear();
                count = 0;
                left = j + wordLen;
            }
        }
    }

    return result;
}
```

### 11. Maximum Number of Vowels in a Substring of Given Length (Medium)
```java
public int maxVowels(String s, int k) {
    int max = 0, count = 0;
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    for (int i = 0; i < s.length(); i++) {
        if (vowels.contains(s.charAt(i))) count++;
        if (i >= k && vowels.contains(s.charAt(i - k))) count--;
        max = Math.max(max, count);
    }

    return max;
}
```

### 12. Count Good Substrings (Easy)
```java
public int countGoodSubstrings(String s) {
    int count = 0;
    for (int i = 0; i <= s.length() - 3; i++) {
        String sub = s.substring(i, i + 3);
        if (sub.charAt(0) != sub.charAt(1) &&
            sub.charAt(1) != sub.charAt(2) &&
            sub.charAt(0) != sub.charAt(2)) {
            count++;
        }
    }
    return count;
}
```

### 13. Longest Substring Without 3 Identical Consecutive Characters (Medium)
```java
public int longestSubstringNoThreeIdentical(String s) {
    int left = 0, maxLen = 0, repeat = 1;
    for (int right = 1; right < s.length(); right++) {
        repeat = (s.charAt(right) == s.charAt(right - 1)) ? repeat + 1 : 1;
        if (repeat == 3) {
            left = right - 1;
            repeat = 2;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

### 14. Maximum Erasure Value (Medium)
```java
public int maximumUniqueSubarray(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    int left = 0, sum = 0, max = 0;

    for (int right = 0; right < nums.length; right++) {
        while (seen.contains(nums[right])) {
            seen.remove(nums[left]);
            sum -= nums[left++];
        }
        seen.add(nums[right]);
        sum += nums[right];
        max = Math.max(max, sum);
    }

    return max;
}
```

### 15. Max Consecutive Ones III (Medium)
```java
public int longestOnes(int[] nums, int k) {
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
        if (nums[right] == 0) k--;
        if (k < 0) {
            if (nums[left] == 0) k++;
            left++;
        }
    }
    return nums.length - left;
}
```
