package cn.nicollcheng.doc.controller;

import cn.nicollcheng.doc.common.CommonResult;
import cn.nicollcheng.doc.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <b><code>UserController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/4/25 13:54.
 *
 * @author nicollcheng
 * @since spring-boot-simple 2021
 */
@RestController
@RequestMapping("/users")
//@CrossOrigin
public class UserController {
    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User().setId("1").setUsername("Tom").setPasswd("123").setSex((byte) 1));
        USERS.add(new User().setId("3").setUsername("Jack").setPasswd("456").setSex((byte) 1));
        USERS.add(new User().setId("5").setUsername("Jane").setPasswd("789").setSex((byte) 2));
    }

    /**
     * @api {GET} /users selectUser
     * @apiVersion 1.0.0
     * @apiGroup UserController
     * @apiName selectUser
     * @apiDescription 用户一览
     * @apiSuccessExample 响应结果示例
     * {
     *      "code": 200,
     *      "message": "操作成功",
     *      "data": [
     *           {
     *               "id": "1",
     *               "username": "Tom",
     *               "passwd": "123",
     *               "sex": 1
     *           }
     *      ]
     * }
     * @apiSuccess {Number} code 响应码
     * @apiSuccess {String} message 提示信息
     * @apiSuccess {List} data 响应信息
     * @apiSuccess {String} data.id 用户Id
     * @apiSuccess {String} data.username 用户名
     * @apiSuccess {String} data.passwd 密码
     * @apiSuccess {Byte} data.sex 性别
     */
    @GetMapping
    public CommonResult selectUser() {
        return CommonResult.success(USERS);
    }


    /**
     * @api {GET} /users/{id} getOne
     * @apiVersion 1.0.0
     * @apiGroup UserController
     * @apiName getOne
     * @apiParam (请求参数) {String} id 用户Id
     * @apiParamExample 请求参数示例
     * id=yJxLQ
     * @apiSuccess (响应结果) {String} id 用户Id
     * @apiSuccess (响应结果) {String} username 用户名
     * @apiSuccess (响应结果) {String} passwd 密码
     * @apiSuccess (响应结果) {Number} sex 性别
     * @apiSuccessExample 响应结果示例
     * {"passwd":"Ho7","sex":72,"id":"eR","username":"zssN2M7gge"}
     */
    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") String id) {
        return USERS.get(0);
    }
}
