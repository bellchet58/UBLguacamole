package com.ublwarriors.guacamole.model;

public class ConnectionGroupPermissionKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group_permission.connection_group_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer connectionGroupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group_permission.permission
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private String permission;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group_permission.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group_permission.connection_group_id
     *
     * @return the value of guacamole_connection_group_permission.connection_group_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getConnectionGroupId() {
        return connectionGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group_permission.connection_group_id
     *
     * @param connectionGroupId the value for guacamole_connection_group_permission.connection_group_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setConnectionGroupId(Integer connectionGroupId) {
        this.connectionGroupId = connectionGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group_permission.permission
     *
     * @return the value of guacamole_connection_group_permission.permission
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group_permission.permission
     *
     * @param permission the value for guacamole_connection_group_permission.permission
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group_permission.user_id
     *
     * @return the value of guacamole_connection_group_permission.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group_permission.user_id
     *
     * @param userId the value for guacamole_connection_group_permission.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}