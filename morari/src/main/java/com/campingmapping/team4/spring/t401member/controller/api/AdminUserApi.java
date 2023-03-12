package com.campingmapping.team4.spring.t401member.controller.api;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t401member.model.dto.UserDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.dto.UserDetailGuestEdit;
import com.campingmapping.team4.spring.t401member.model.service.*;

import jakarta.servlet.http.HttpServletRequest;

/**
 * This is the API controller for admin
 * 後台 API 控制器
 */
@Controller
@RequestMapping("admin/camper/api")
public class AdminUserApi {
    @Autowired
    UserService userService;

    /**
     * Get all user details for admin view.
     * 拿取全部使用者(包含權限) SA用
     * 
     * @return List<UserDetailAdminWeb>
     */
    @GetMapping("/showall")
    @ResponseBody
    public List<UserDetailAdminWeb> getAllUser() {
        return userService.showAllUser();
    }

    /**
     * Update a user's details by admin.
     * 修改 使用者資料(包含權限) SA用
     * 
     * @param user (UserDetailAdminWeb)
     * @return a ResponseEntity with no body, indicating success(200) or
     *         failure(500)
     *         回傳狀態碼 成功(200) or 失敗(500)
     */
    @PutMapping("/user")
    @ResponseBody
    public ResponseEntity<Void> updateUser(@RequestBody UserDetailAdminWeb user) {

        Boolean saveSuccess = userService.adminUpdateUser(user);
        if (saveSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Lock or unlock a user's account by admin.
     * 封鎖 或 解鎖 使用者權限 SA用
     * 
     * @param uid              the UUID of the user to update
     *                         被更動帳戶的 UUID
     * @param accountnonlocked a boolean value indicating whether the account is
     *                         locked
     *                         是否封鎖 封鎖(true) or 解除(false)
     * @return a ResponseEntity with no body, indicating success(200) or
     *         failure(500)
     *         回傳狀態碼 成功(200) or 失敗(500)
     */
    @PutMapping("/accountlocked/{uid}")
    @ResponseBody
    public ResponseEntity<Void> accountlocked(@PathVariable("uid") UUID uid,
            @RequestBody Boolean accountnonlocked) {

        Boolean saveSuccess = userService.updateaccountlocked(uid, accountnonlocked);
        if (saveSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Enable or disable a user's account by admin.
     * 管理帳號是否啟用 SA用
     * 
     * @param uid       the UUID of the user to update
     *                  被更動帳戶的 UUID
     * @param isenabled a boolean value indicating whether the account is enabled
     *                  是否啟用 啟用(true) or 未啟用(false)
     * @return a ResponseEntity with no body, indicating success(200) or
     *         failure(500)
     *         回傳狀態碼 成功(200) or 失敗(500)
     */
    @PutMapping("/enabled/{uid}")
    @ResponseBody
    public ResponseEntity<Void> enabled(@PathVariable("uid") UUID uid, @RequestBody Boolean isenabled) {
        Boolean saveSuccess = userService.updateenabled(uid, isenabled);
        if (saveSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get a guest user's details for editing.
     * 拿取當前使用者資料
     * 
     * @param request the HttpServletRequest (傳入service 來拿取UUID)
     * @return UserDetailGuestEdit
     */
    @GetMapping("/guestdetail")
    @ResponseBody
    public UserDetailGuestEdit getUesrDetailGuestEdit(HttpServletRequest request) {
        return userService.getUesrDetailGuestEdit(request);
    }

    /**
     * Get a list of user registration dates.
     * 拿取所有會員註冊時間
     * 
     * @return List<Date>
     */
    @GetMapping("/userregisterdate")
    @ResponseBody
    public List<Date> getUserRegisterDate() {
        return userService.getUserRegisterDate();
    }

    /**
     * Get a user's roles.
     * 拿取當前使用者權限
     *
     * @param request the HttpServletRequest (傳入service 來拿取UUID)
     * @return a collection of GrantedAuthority 
     */
    @GetMapping("/userroles")
    @ResponseBody
    public Collection<? extends GrantedAuthority> getuserroles(HttpServletRequest request) {
        return userService.getUserRoles(request);
    }

}
