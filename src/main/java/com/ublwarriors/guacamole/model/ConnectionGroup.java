package com.ublwarriors.guacamole.model;

public class ConnectionGroup {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group.connection_group_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer connectionGroupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group.parent_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group.connection_group_name
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private String connectionGroupName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group.type
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group.max_connections
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer maxConnections;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_group.max_connections_per_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer maxConnectionsPerUser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group.connection_group_id
     *
     * @return the value of guacamole_connection_group.connection_group_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getConnectionGroupId() {
        return connectionGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group.connection_group_id
     *
     * @param connectionGroupId the value for guacamole_connection_group.connection_group_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setConnectionGroupId(Integer connectionGroupId) {
        this.connectionGroupId = connectionGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group.parent_id
     *
     * @return the value of guacamole_connection_group.parent_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group.parent_id
     *
     * @param parentId the value for guacamole_connection_group.parent_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group.connection_group_name
     *
     * @return the value of guacamole_connection_group.connection_group_name
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public String getConnectionGroupName() {
        return connectionGroupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group.connection_group_name
     *
     * @param connectionGroupName the value for guacamole_connection_group.connection_group_name
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setConnectionGroupName(String connectionGroupName) {
        this.connectionGroupName = connectionGroupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group.type
     *
     * @return the value of guacamole_connection_group.type
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group.type
     *
     * @param type the value for guacamole_connection_group.type
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group.max_connections
     *
     * @return the value of guacamole_connection_group.max_connections
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getMaxConnections() {
        return maxConnections;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group.max_connections
     *
     * @param maxConnections the value for guacamole_connection_group.max_connections
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_group.max_connections_per_user
     *
     * @return the value of guacamole_connection_group.max_connections_per_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getMaxConnectionsPerUser() {
        return maxConnectionsPerUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_group.max_connections_per_user
     *
     * @param maxConnectionsPerUser the value for guacamole_connection_group.max_connections_per_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setMaxConnectionsPerUser(Integer maxConnectionsPerUser) {
        this.maxConnectionsPerUser = maxConnectionsPerUser;
    }
}