package cn.shimeng.utils;

import org.ini4j.Ini;
import org.ini4j.Profile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class IniUtils {
    private IniUtils() {

    }
    private static Ini ini;

    /**
     * 初始化ini文件
     *
     * @param iniPath ini文件路径
     * @author zhujx
     * @date 2021/4/17 13:25
     */
    public static void initIni(String iniPath) {
        try {
            ini = new Ini(new File(iniPath));
        } catch (IOException e) {
            //log.error(e.getMessage(), e);
            System.err.printf(e.getMessage(),e);
            ini = null;
        }
    }


    /**
     * 读取ini文件
     *
     * @param sectionKey section的值
     * @param keyList    key数组
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @author zhujx
     * @date 2021/4/17 13:25
     */
    public static Map<String, String> readIni(String sectionKey, List<String> keyList) {
        if (keyList == null || keyList.isEmpty()) {
            return null;
        }
        Profile.Section section = ini.get(sectionKey);
        if (section == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>(16);
        for (String key : keyList) {
            String value = section.get(key);
            map.put(key, value);
        }
        return map;
    }

    /**
     * 读取ini文件
     *
     * @param sectionKey section的值
     * @param key        key
     * @return java.lang.String
     * @author zhujx
     * @date 2021/4/17 13:25
     */
    public static String readIni(String sectionKey, String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        Profile.Section section = ini.get(sectionKey);
        if (section == null) {
            return null;
        }
        return section.get(key);
    }


    /**
     * 添加值
     *
     * @param origin 包含section key value
     * @author zhujx
     * @date 2021/4/17 13:27
     */
    public static void creatIni(Map<String, Map<String, String>> origin) throws IOException {
        //将文件内容保存到ini对象中
        Set<String> sectionKeySet = origin.keySet();
        for (String sectionKey : sectionKeySet) {
            if (StringUtils.isBlank(sectionKey)) {
                continue;
            }
            Map<String, String> keyValue = origin.get(sectionKey);
            Set<String> keySet = keyValue.keySet();
            for (String key : keySet) {
                if (StringUtils.isBlank(key)) {
                    continue;
                }
                String value = keyValue.get(key);
                if (StringUtils.isBlank(value)) {
                    value = "";
                }
                ini.add(sectionKey, key, value);
            }
        }
        //将文件内容保存到文件中
        ini.store();
    }

    /**
     * 添加值
     *
     * @param sectionKey sectionKey
     * @param key        key
     * @param value      value
     * @author zhujx
     * @date 2021/4/17 13:27
     */
    public static void creatIni(String sectionKey, String key, String value) throws IOException {
        //将文件内容保存到ini对象中
        if (StringUtils.isBlank(sectionKey)) {
            return;
        }
        if (StringUtils.isBlank(key)) {
            return;
        }
        Profile.Section section = ini.get(sectionKey);
        if (section != null) {
            String oldValue = section.get(key);
            if (oldValue != null) {
                section.remove(key);
            }
        }
        ini.add(sectionKey, key, value);
        //将文件内容保存到文件中
        ini.store();
    }

    /**
     * 清除ini
     *
     * @author zhujx
     * @date 2021/4/17 13:28
     */
    public static void clean() {
        ini = null;
    }

}
