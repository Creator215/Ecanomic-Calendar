package com.example.ekanomikkalendar;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Locale;
import java.util.Objects;

public class ECall {
    public String region = "";
    public String day = "";
    public String url = "";
    public String[][] filter_data = null;
    public int sizes = 0;

    public ECall(String region,String day){
        this.region = region;
        this.day = day;
        this.url = String.format("https://www.litefinance.org/trading/calendar/?gmt=%s&date=%s&countries=us&priorities=2-3",this.region,this.day);

        open_connection(this.url);
    }
    private void open_connection(String url){
        Connection connection = Jsoup.connect(url);
        try{
            Element document = connection.get().selectFirst("table.main.js-table");
            assert document != null;
            Elements data_row_odd = document.select("tr.odd.item");
            Elements data_row_couple = document.select("tr.even.item");

            int odd = data_row_odd.size();
            int couple = data_row_couple.size();

            this.sizes = odd + couple;

            Element array[] = new Element[odd+couple];

            int index = 0;

            for(int i = 0;i < odd+couple;i += 2){
                if(index == odd){
                    break;
                }
                else{
                    array[i] = (data_row_odd.get(index));
                    index += 1;
                }
            }

            int index2 = 0;

            for (int j = 1;j < odd + couple;j +=2){
                if(index2 == couple){
                    break;
                }
                else{
                    array[j] = (data_row_couple.get(index2));
                    index2 += 1;
                }
            }
            this.filter_data = new String[odd+couple][8];
            for(int index3 = 0;index3 < odd + couple;index3 ++){
                this.filter_data[index3][0] = array[index3].select("td.event-time.js-show-event-info").html();
                this.filter_data[index3][1] = String.format("https://flagsapi.com/%s/flat/64.png",array[index3].select("span").attr("class").toUpperCase(Locale.ROOT).replace("FLAG FLAG-",""));
                this.filter_data[index3][2] = array[index3].select("span").attr("class").toUpperCase(Locale.ROOT).replace("FLAG FLAG-","");
                this.filter_data[index3][3] = array[index3].select("ul").attr("class");
                this.filter_data[index3][4] = array[index3].select("td.js-show-event-info.event-name").html();
                this.filter_data[index3][5] = Objects.requireNonNull(array[index3].select("td.js-show-event-info").last()).html();
                this.filter_data[index3][6] = array[index3].select("td.color-prog").html();
                this.filter_data[index3][7] = array[index3].select("td.color-fact").html();
            }
        }catch (Exception exception){
            this.filter_data[0][0] = "None";
        }
    }
    public String[][] getFilter_data(){
        return filter_data;
    }
    public int get_size(){
        return this.sizes;
    }
}


//week//next//current//prev