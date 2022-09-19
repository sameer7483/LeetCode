class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for(String path : paths){
            String[] files = path.split(" ");
            for(int i=1;i<files.length;i++){
                int idxBegin = files[i].indexOf('(');
                int idxEnd = files[i].indexOf(')');
                String cont = files[i].substring(idxBegin, idxEnd+1);
                List<String> l = m.getOrDefault(cont, new ArrayList<>());
                l.add(files[0]+"/"+files[i].substring(0, idxBegin));
                m.put(cont, l);
            }
        }
        for(Map.Entry<String, List<String>> ent : m.entrySet()){
            if(ent.getValue().size() > 1)
                res.add(ent.getValue());
        }
        return res;
    }
}