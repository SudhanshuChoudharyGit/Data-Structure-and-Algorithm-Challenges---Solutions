class Solution {
    public String reformatDate(String date) {
        String[] arr = date.split(" ");
        Map<String,String> month = new HashMap<>();
        month.put("Jan","01");
        month.put("Feb","02");
        month.put("Mar","03");
        month.put("Apr","04");
        month.put("May","05");
        month.put("Jun","06");
        month.put("Jul","07");
        month.put("Aug","08");
        month.put("Sep","09");
        month.put("Oct","10");
        month.put("Nov","11");
        month.put("Dec","12");

        String dateStr = arr[0];
        dateStr = dateStr.substring(0,dateStr.length()-2);
        if(Integer.valueOf(dateStr)<10) dateStr = "0"+dateStr;
        String monthStr = arr[1];
        String yearStr = arr[2];

        String fDate = "";

        fDate = yearStr
                + "-"+ month.get(monthStr)
                + "-"+ dateStr;

        return fDate;

    }
}