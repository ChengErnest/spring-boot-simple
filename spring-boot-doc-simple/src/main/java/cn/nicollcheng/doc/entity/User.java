package cn.nicollcheng.doc.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <b><code>User</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/4/25 13:52.
 *
 * @author nicollcheng
 * @since spring-boot-simple 2021
 */
@Data
@Accessors(chain = true)
public class User {
    private String id;
    private String username;
    private String passwd;
    private byte sex;
}
