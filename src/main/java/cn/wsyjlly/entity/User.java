package cn.wsyjlly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.16 - 16:49
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
@TableName(value="user")
public class User implements Serializable {
    @TableId(value="id" , type= IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private Boolean enable;
    private Boolean locked;
    @TableField(exist = false)
    private List<Role> roles;
    @TableField(exist = false)
    private List<UserRole> userRoles;


}
