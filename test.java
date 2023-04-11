// Перемножение цифр числа, чтобы получилась одна цифра. Выводим на экран количество итераций.

// class test {
// 	public static int persistence(long n) {
     
//         String strn = Long.toString(n);
//         char[] charArray = strn.toCharArray();
//         int mult = Character.digit(charArray[0], 10);
//         for (int i = 1; i < charArray.length; i++){
//         mult *= Character.digit(charArray[i], 10);                    
//         }     
//         return mult;
//     }

//         public static void main(String[] args) {
//         long number = 999;
//         int count = 0; 
//         long res = number;
//         while (res >= 10){
//             res = persistence(res);
//             count+=1;  
//         }         
                 
//         // System.out.println(res);
//         System.out.println(count);

//     }
	
// }

class test {
	public static int persistence(long n) {
        int count = 0;
        if (n < 10){
            return count;
        }
        String strn = Long.toString(n);
        char[] charArray = strn.toCharArray();
        int mult = Character.digit(charArray[0], 10);
        for (int i = 1; i < charArray.length; i++){
            mult *= Character.digit(charArray[i], 10);                    
        }     
        return mult;
    }

        public static void main(String[] args) {
        long number = 999;
        int count = 0; 
        long res = number;
        while (res >= 10){
            res = persistence(res);
            count+=1;  
        }         
                 
        // System.out.println(res);
        System.out.println(count);

    }
	
}