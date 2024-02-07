/*
 *  Supoose we are having input "DDUUDDDUUDD"
 *  in this we have to calculate maximum valley he walk on top
 */
class problem {
    public static void main(String[] args) {

        String s = "UU DD UUUU DDD UUU DD";
        System.err.println("Value is :- " + calculateValley(s));

    }

    static int calculateValley(String s) {
        int valley = 0;
        char[] arr = s.toCharArray();
        int count = 0;
        int lastMaxUp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            if (i > 0 && lastMaxUp == 0) {
                valley++;
            }
            if (arr[i] == 'U') {
                count++;
            } else if (arr[i] == 'D') {
                if (count > lastMaxUp) {
                    if (lastMaxUp < count && valley > 0) {
                        valley = 1;
                    } else {
                        valley++;
                    }
                    lastMaxUp = count;
                }
                count--;
            }
            System.err.println(i+" position "+valley+" count:- "+count +"     LastMaxUp:- "+lastMaxUp);
        }

        return valley;
    }
}
