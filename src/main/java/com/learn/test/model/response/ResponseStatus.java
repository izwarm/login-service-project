package com.learn.test.model.response;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {
    // success response

    HTTP_STATUS_OK(200, "Success", HttpStatus.OK, "Success"),
    API_REQUEST_SUCCEEDED(201, "API Request is already succeeded", HttpStatus.OK, "API Request berhasil"),
    API_REQUEST_PARTIALLY_SUCCEEDED(202, "Api Request is partially succeed", HttpStatus.OK, "API Request berhasil sebagian"),
    INVALID_REQUEST(400, "Invalid request", HttpStatus.BAD_REQUEST, "Invalid request!"),
    INVALID_JSON_FORMAT(500, "Invalid json string format", HttpStatus.INTERNAL_SERVER_ERROR, "Format JSON string untuk data tidak valid"),
    NO_DATA_FOUND(401, "No data found", HttpStatus.BAD_REQUEST, "Data tidak ditemukan"),
    NO_USER_FOUND(401, "No user found", HttpStatus.BAD_REQUEST, "Data user tidak ditemukan"),
    INTERNAL_SERVER_ERROR(500, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR, "Sistem mengalami gangguan. Silahkan coba beberapa saat lagi"),
    ACTIVATION_SUCCEEDED(201, "Activation succeeded", HttpStatus.OK, "Aktivasi berhasil"),
    USER_ID_ALREADY_ACTIVATED_BY_OTHER(401, "Id has been activated by another advocate", HttpStatus.BAD_REQUEST, "Id telah diaktifkan oleh user lain"),
    USER_ID_ALREADY_ACTIVATED(402, "Id has been activated", HttpStatus.BAD_REQUEST, "Id sudah aktif"),
    ACTIVATION_ERROR(403, "Activation error", HttpStatus.BAD_REQUEST, "Error pada aktivasi"),
    NO_USER_LOGIN_PASSWORD_FOUND(407, "No user login password found", HttpStatus.BAD_REQUEST, "Tidak ditemukan password untuk user"),
    NO_USER_LOGIN_FOUND(408, "No user login found", HttpStatus.BAD_REQUEST, "Tidak ditemukan user"),
    INVALID_PARAMETER_FORMAT(411, "Invalid parameter format", HttpStatus.BAD_REQUEST, "Format parameter tidak sesuai"),
    INVALID_CHECKIN(412, "Invalid checkin", HttpStatus.BAD_REQUEST, "Checkin tidak valid"),
    DUPLICATE_ENTRY(416, "Data already exists", HttpStatus.BAD_REQUEST, "Data already exists"),
    ON_PROCESSING(417, "Data is being processed", HttpStatus.BAD_REQUEST, "Data is being processed"),
    ROLE_LEVEL_HAS_ACTIVE_USER(444, "Role level has active user", HttpStatus.BAD_REQUEST, "Role level has active user"),
    INVALID_USERNAME_PASSWORD(461, "Invalid username or password", HttpStatus.BAD_REQUEST, "Invalid username or password"),
    INVALID_PHONE_NUMBER(463, "Invalid phone number", HttpStatus.BAD_REQUEST, "Invalid phone number"),
    INACTIVE_USER_LOGIN(464, "Inactive user login", HttpStatus.BAD_REQUEST, "Invalid user login"),
    INVALID_AMOUNT(467, "Invalid amount", HttpStatus.BAD_REQUEST, "Invalid amount"),
    INVALID_ITEM(468, "Invalid item", HttpStatus.BAD_REQUEST, "Invalid item"),
    INVALID_STATUS(469, "Invalid status", HttpStatus.BAD_REQUEST, "Invalid status"),
    TOTAL_LIMIT_IS_REACHED(469, "Total limit is reached", HttpStatus.BAD_REQUEST, "Campaign item has reached its total limit"),
    USER_ALREADY_LOGIN(471, "User already login", HttpStatus.BAD_REQUEST, "User already login"),
    USER_SUSPENDED(475, "User is inactive or is blocked", HttpStatus.UNAUTHORIZED, "User is inactive or is blocked"),
    INVALID_OLD_PASSWORD(476, "User is inactive or is blocked", HttpStatus.BAD_REQUEST, "Invalid old password"),
    PHONE_NUMBER_ALREADY_EXIST(450, "Phone number already exist", HttpStatus.BAD_REQUEST, "Phone number already exist"),
    UNAUTHORIZED_APPROVAL(486, "Unauthorized Approval Found", HttpStatus.UNAUTHORIZED, "Unauthorized Approval Found"),
    INVALID_MAXIMUM_AMOUNT(481, "Invalid Maximum Amount", HttpStatus.BAD_REQUEST, "Invalid Maximum Amount"),
    INVALID_MULTIPLE_OF_AMOUNT(482, "Invalid Multiple of Amount", HttpStatus.BAD_REQUEST, "Invalid Multiple of Amount"),
    NO_GOPAY_ID_FOUND(484, "Gopay ID not found", HttpStatus.NOT_FOUND, "Gopay ID not found"),
    UNABLE_INACTIVATE_DATA(487, "Unable Inactivate Data", HttpStatus.BAD_REQUEST, "Unable Inactivate Data"),
    INVALID_USER_TYPE(489, "Invalid User Type", HttpStatus.BAD_REQUEST, "Invalid User Type"),
    REGENCY_CODE_DOES_NOT_NULL(401, "RegencyCode does not exist", HttpStatus.BAD_REQUEST, "RegencyCode does not exist"),
    //NEW RESPONSE STATUS///
    //FIRST THREE DIGITS SHOULD BE RESERVED ONLY TO A BUSINESS ENTITY (MAIN)//

    //100xxx TERRITORY
    TERRITORY_REGENCY_NOT_FOUND(100001, "Regency is not found under the territory", HttpStatus.NOT_FOUND, "Kota/Kabupaten tidak berada di dalam wilayah"),
    TERRITORY_REGENCY_HAS_MULTIPLE(100002, "The regency has multiple territories", HttpStatus.BAD_REQUEST, "The regency has multiple territories");

    private int internalStatusCode;
    private String description;
    private HttpStatus httpStatus;
    private String prettyMessage;

    ResponseStatus(int statusCode, String description, HttpStatus httpStatus, String prettyMessage) {
        this.internalStatusCode = statusCode;
        this.description = description;
        this.httpStatus = httpStatus;
        this.prettyMessage = prettyMessage;
    }

    public static ResponseStatus fromString(int statusCode) {

        for (ResponseStatus rs : ResponseStatus.values()) {
            if (rs.getStatusCode() == statusCode) {
                return rs;
            }
        }

        return null;
    }

    public int getStatusCode() {
        return internalStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getPrettyMessage() {
        return prettyMessage;
    }
}
