package cn.ucai.www.lyricview;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/5.
 */
public class Utils {

    public static void setupLyricResource(InputStream is,String charsetName) throws Exception {
        if(is!=null){
            LyricInfo info=new LyricInfo();
            info.setSong_lines(new ArrayList<LyricLine>());

            InputStreamReader inputStreamReader=new InputStreamReader(is,charsetName);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String line=null;
            while((line=reader.readLine())!=null){
                analyzeLyric(info,line);

            }
            reader.close();
            inputStreamReader.close();
            is.close();
        }
    }

    private static void analyzeLyric(LyricInfo info, String line) {

    }
}
