package com.example.demo.Model;

import com.example.demo.Constants.Database_Table;
import com.example.demo.Constants.Database_Table.DeviceType;
import com.example.demo.Constants.Database_Table.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name =Database_Table.AUTH_TOKEN)
public class Auth_Token {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "access_token", unique = true, nullable = false, length = 255)
    private String accessToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE'")
    private Status status = Status.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;

//    @Column(name = "user_id", nullable = false)
//    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "device_token")
    private String deviceToken;

    @Column(name = "access_token_expire_on")
    private LocalDateTime accessTokenExpireOn;

    @Column(name = "refresh_token_expire_on")
    private LocalDateTime refreshTokenExpireOn;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "device_unique_id")
    private String deviceUniqueId;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_on", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedOn;



    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public LocalDateTime getAccessTokenExpireOn() {
		return accessTokenExpireOn;
	}

	public void setAccessTokenExpireOn(LocalDateTime accessTokenExpireOn) {
		this.accessTokenExpireOn = accessTokenExpireOn;
	}

	public LocalDateTime getRefreshTokenExpireOn() {
		return refreshTokenExpireOn;
	}

	public void setRefreshTokenExpireOn(LocalDateTime refreshTokenExpireOn) {
		this.refreshTokenExpireOn = refreshTokenExpireOn;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDeviceUniqueId() {
		return deviceUniqueId;
	}

	public void setDeviceUniqueId(String deviceUniqueId) {
		this.deviceUniqueId = deviceUniqueId;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	// PrePersist and PreUpdate methods for default values
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = LocalDateTime.now();
    }

    // Constructors, getters, and setters
}
