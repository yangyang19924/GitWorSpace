import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/21.
 */
public class TestDate {

    public static void main(String[] args) {
        Date date = new Date();   //获取系统当前时间
        System.out.println("当前时间(ms)："+date.getTime());
        System.out.println("当前时间(date)："+date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sd = sdf.format(date);
        System.out.println("当前时间(String)："+sd);

        String s="2017-06-28T09:52";
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            Date date1 = sdf1.parse(s);
            System.out.println("当前时间(date):"+ date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
