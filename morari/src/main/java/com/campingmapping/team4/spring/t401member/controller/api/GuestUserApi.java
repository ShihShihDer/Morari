package com.campingmapping.team4.spring.t401member.controller.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t401member.model.dto.UserDetailGuestEdit;
import com.campingmapping.team4.spring.t401member.model.dto.UserDetailGuestWeb;
import com.campingmapping.team4.spring.t401member.model.service.*;
import com.campingmapping.team4.spring.utils.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

/**
 * 
 * This is the API controller for guest users.
 * 
 * 前台 API控制器。
 */
@Controller
@RequestMapping("guest/camper/api")
@RequiredArgsConstructor
public class GuestUserApi {

    @Autowired
    UserService userService;

    private final JwtService jwtService;

    /**
     * 
     * Get the shot image of a user.
     * 獲取當前用戶大頭貼。
     * 
     * @param request HttpServletRequest (傳入service 來拿取UUID)
     * @return the shot image of the user (String)URL
     *         大頭貼的網址
     */
    @GetMapping("/shot")
    @ResponseBody
    public String getShot(HttpServletRequest request) {
        return userService.getShot(request);
    }

    /**
     * 
     * Update the shot image of a user.
     * 更新用戶的大頭貼。
     * 
     * @param id   (String) user id
     * @param file (MultipartFile) uploaded file
     * @return the result of updating shot image (String)
     *         大頭貼的網址
     */
    @PutMapping("/shot")
    @ResponseBody
    public String putShot(@RequestParam("uid") String id,
            @RequestParam("file") MultipartFile file) {
        return userService.updateShot("usershot" + id, file);
    }

    /**
     * 
     * Get the nickname of a user.
     * 獲取當前用戶的暱稱。
     * 
     * @param request (HttpServletRequest) HTTP request
     * @return the nickname of the user (String)
     */
    @GetMapping("/nickname")
    @ResponseBody
    public String getNickname(HttpServletRequest request) {
        return userService.getNickname(request);
    }

    /**
     * 
     * Get the detail information of a user for guest view.
     * 獲取用戶的詳細信息。(前台用 公開)
     * 
     * @param uid (UUID) user id
     * @return the detail information of the user for guest view
     *         (UserDetailGuestWeb)
     */
    @GetMapping("/userdetail/{uid}")
    @ResponseBody
    public UserDetailGuestWeb getUserDetail(@PathVariable("uid") UUID uid) {
        return userService.getUserDetail(uid);
    }

    /**
     * 
     * Update the detail information of a user for guest view.
     * 更新當前用戶的詳細信息。用戶後台(一般權限)
     * 
     * @param uid                 (UUID) user id
     * @param userDetailGuestEdit (UserDetailGuestEdit) the updated detail
     *                            information of the user
     * @param request             (HttpServletRequest) HTTP request
     * @return a ResponseEntity with no body, indicating success(200), failure(500),
     *         or unauthorized access(401)
     * @return ResponseEntity 狀態碼, 成功(200) 失敗(500) 或未經授權(401)
     */
    @PutMapping("/userdetail/{uid}")
    @ResponseBody
    public ResponseEntity<Void> updateUserDetail(@PathVariable("uid") UUID uid,
            @RequestBody UserDetailGuestEdit userDetailGuestEdit,
            HttpServletRequest request) {
        if (jwtService.getUId(request).equals(uid)) {
            Boolean saveSuccess = userService.guestUpdateUser(userDetailGuestEdit);
            if (saveSuccess) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
