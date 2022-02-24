public class Codec {
    List<String> l;
    public Codec(){
        l = new ArrayList<>();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        l.add(longUrl);
        return String.valueOf(l.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int idx = Integer.parseInt(shortUrl);
        return l.get(idx);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));