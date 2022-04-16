package com.mathematics;

/**
 * @author wangyu
 * @date: 2020-05-11 09:01
 *
 * <p>
 */
public class Test {

    public static void main(String[] args) {
        for (ABility value : ABility.values()) {
//            System.out.println(value);
            System.out.println(String.format("value : %s | code : %s  | type %s | name :%s",value,2222,value.abiliityType,value.abilityName));
        }

        ABility aBility = ABility.valueOf("Plc".toLowerCase());

        System.out.println();
    }

    public enum ABility {
        plc( "plc", "系统数据"),
        rtu("rtu", "系统数据"),
        scada( "scada", "系统数据"),
        dcs( "dcs", "系统数据"),
        mes( "dcs", "系统数据"),

        mobus( "mobus", "协议数据"),
        opc( "opc", "协议数据"),
        dnp3( "dnp3", "协议数据"),
        profinet( "profinet", "协议数据"),
        EtherNet("EtherNet", "协议数据"),


        SC( "生产", "敏感数据"),
        zl( "质量", "敏感数据"),
        gy( "工艺", "敏感数据"),
        wl( "物流", "敏感数据"),
        sb("设备", "敏感数据"),

        gjsj( "攻击事件", "安全数据"),
        bdsj( "病毒事件", "安全数据"),
        wgcj( "违规采集", "安全数据"),
        wgfw("违规访问", "安全数据"),
        sjxl( "数据泄露", "安全数据");


        /**
         * 权限名称
         */
        private String abilityName;
        /**
         * 权限类型
         */
        private String abiliityType;
        ABility( String abilityName, String abiliityType) {
            this.abilityName = abilityName;
            this.abiliityType = abiliityType;
        }



        public String getAbilityName() {
            return abilityName;
        }

        public ABility setAbilityName(String abilityName) {
            this.abilityName = abilityName;
            return this;
        }

        public String getAbiliityType() {
            return abiliityType;
        }

        public ABility setAbiliityType(String abiliityType) {
            this.abiliityType = abiliityType;
            return this;
        }


    }
}