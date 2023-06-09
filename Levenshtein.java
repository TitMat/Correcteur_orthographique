public class Levenshtein {

    public static int distance(String str1, String str2) {
        int ret = 0;
        if (str1.equals("")){
            return str2.length();
        }
        if (str2.equals("")){
            return str1.length();
        }
        char sequence1 = str1.charAt(str1.length()-1);
        char sequence2 = str2.charAt(str2.length()-1);
        if (sequence1==sequence2){
            ret=ret+distance(déconcatenation(str1),déconcatenation(str2));
        }
        else {
            int changer=distance(déconcatenation(str1)+sequence2,str2);
            int supprimer=distance(déconcatenation(str1),str2);
            int ajouter=distance(str1+sequence2,str2);
            int inter =Integer.min(changer,supprimer);
            int inter2=Integer.min(ajouter,inter);
            ret=ret+inter2+1;
        }

        // write your code here
        return ret;
    }

    //enlève la dernière lettre du mot
    public static String déconcatenation(String mot){
        if (mot.equals("")){
            return "";
        }
        char dernier = mot.charAt(mot.length()-1);
        String result= new String();
        for(int a =0; a<=mot.length()-1; a++){
            result=result+""+mot.charAt(a);
        }
        return result;

    }
    public static int distance2(String w, String u) {
        int n = w.length();
        n++;
        int m= u.length();
        m++;
        int[][] values = new int[n][m] ;
        for( int i=0; i<n; i++){
            values[i][0]=i;
        }
        for( int i=0; i<m; i++) {
            values[0][i] = i;
        }
        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                char last_w=w.charAt(i-1);
                char last_u=u.charAt(j-1);
                if (last_w == last_u){
                    values[i][j]=values[i-1][j-1];
                }
                else {
                    values[i][j] = 1+Integer.min(Integer.min(values[i-1][j-1],values[i-1][j]),values[i][j-1]);
                }
            }
        }
        return values[n-1][m-1];

    }
}



