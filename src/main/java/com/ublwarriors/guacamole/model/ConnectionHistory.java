package com.ublwarriors.guacamole.model;

import java.util.Date;

public class ConnectionHistory {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_history.history_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer historyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_history.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_history.connection_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Integer connectionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_history.start_date
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Date startDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guacamole_connection_history.end_date
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    private Date endDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_history.history_id
     *
     * @return the value of guacamole_connection_history.history_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getHistoryId() {
        return historyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_history.history_id
     *
     * @param historyId the value for guacamole_connection_history.history_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_history.user_id
     *
     * @return the value of guacamole_connection_history.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_history.user_id
     *
     * @param userId the value for guacamole_connection_history.user_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_history.connection_id
     *
     * @return the value of guacamole_connection_history.connection_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Integer getConnectionId() {
        return connectionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_history.connection_id
     *
     * @param connectionId the value for guacamole_connection_history.connection_id
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_history.start_date
     *
     * @return the value of guacamole_connection_history.start_date
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_history.start_date
     *
     * @param startDate the value for guacamole_connection_history.start_date
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guacamole_connection_history.end_date
     *
     * @return the value of guacamole_connection_history.end_date
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guacamole_connection_history.end_date
     *
     * @param endDate the value for guacamole_connection_history.end_date
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}