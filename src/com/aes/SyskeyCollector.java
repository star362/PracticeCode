package com.aes;

import java.util.Map;

/**
 * Syskey收集器
 * Create Date: 2020年2月24日<br>
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 * Copyright (C) 2020 botany.com All Right Reserved.<br>
 *
 * @author botany
 * @version 1.0
 */
public interface SyskeyCollector {

    /**
     * 收集Syskey,key 为sid,value 为syskey
     *
     * @return
     */
    public Map<Integer, String> collectSyskey();

}
