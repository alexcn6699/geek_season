class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String domain : cpdomains) {
            String[] cpinfo = domain.split("\\s+"); // space split, front is int, [1] is domain
            String[] arrayDomain = cpinfo[1].split("\\."); // doc split each domain
            int cnt = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int j = arrayDomain.length - 1; j >= 0; j--) {
                cur = arrayDomain[j] + (j < arrayDomain.length - 1 ? "." : "") + cur;
                map.put(cur, map.getOrDefault(cur, 0) + cnt);
            }
        }      
       
        List<String> res = new ArrayList<>();
        for (String dom : map.keySet()) {
            res.add("" + map.get(dom) + " " + dom);
        }
        return res;
    }
}