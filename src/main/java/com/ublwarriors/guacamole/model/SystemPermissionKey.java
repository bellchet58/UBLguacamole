package com.ublwarriors.guacamole.model;

public class SystemPermissionKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_system_permission.permission
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private String permission;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_system_permission.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_system_permission.permission
     *
     * @return the value of guacamole_system_permission.permission
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_system_permission.permission
     *
     * @param permission the value for guacamole_system_permission.permission
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_system_permission.user_id
     *
     * @return the value of guacamole_system_permission.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_system_permission.user_id
     *
     * @param userId the value for guacamole_system_permission.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}