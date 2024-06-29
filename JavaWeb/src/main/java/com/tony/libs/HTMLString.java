package com.tony.libs;

public class HTMLString {
    // recebe uma string e codifica os caracteres especiais HTML
    public static String myEncode(String tag) {
        if (tag == null) {
            return null;
        }
        int n = tag.length();
        StringBuilder sb = new StringBuilder(n * 2);
        for (int i = 0; i < n; i++) {
            char c = tag.charAt(i);
            switch (c) {
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '&':
                sb.append("&amp;");
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static void main (String[] args) {
    	String s =  myEncode("<p>Em HTML usamos &lt;BR&gt; para abrir nova linha.</p>");
    	
    	System.out.println(s);
    	
    	
    }
}