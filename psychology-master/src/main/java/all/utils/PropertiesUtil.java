package all.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 读取properties文件的工具类
 */
public class PropertiesUtil {
    /**
     * 读取文件的静态方法
     * @param path   文件路径（properties所在路径）
     * @return
     */
    public static Map<String, String> getProperties(String path){
        Properties prop=new Properties();
        Map<String,String> result=new HashMap<String, String>();
        try {
            //读取文件内容到prop中,将文件中的键值对以键值方式存储到prop对象中
            prop.load(new FileInputStream(new File(path)));
            //prop是map的子类，所以遍历方式相同
            Set<Map.Entry<Object, Object>> set = prop.entrySet();
            for (Map.Entry<Object, Object> e : set) {
                //将键值对存放进map中
                result.put(String.valueOf(e.getKey()),String.valueOf(e.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回map，map中保存的就是url，driver等四个键值对
        return result;
    }
}
