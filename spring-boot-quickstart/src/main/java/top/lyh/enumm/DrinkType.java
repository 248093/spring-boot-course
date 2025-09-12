package top.lyh.enumm;

/**
 * 饮料类型枚举
 */
public enum DrinkType {
    COFFEE("咖啡"),
    TEA("奶茶"),
    JUICE("果汁");

    private final String description;

    DrinkType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 根据描述获取饮料类型
     * @param description 中文描述
     * @return 对应的饮料类型
     */
    public static DrinkType fromDescription(String description) {
        for (DrinkType type : DrinkType.values()) {
            if (type.getDescription().equals(description)) {
                return type;
            }
        }
        throw new IllegalArgumentException("未知的饮料类型: " + description);
    }
}
