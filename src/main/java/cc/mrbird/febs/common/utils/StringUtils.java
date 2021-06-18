package cc.mrbird.febs.common.utils;

import java.util.UUID;

public class StringUtils {

    /**
     * 获得GUID并去除空格
     * @return
     */
    public static String getGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
