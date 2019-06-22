package cn.wsyjlly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wsyjlly
 * @create 2019.06.22 - 12:26
 **/
@Data
@Accessors(chain = true)
@TableName("user_role")
public class UserRole {
    @TableId(value="id" , type= IdType.AUTO)
    private Integer id;
    private Long uid;
    private Integer rid;
    @TableField(exist = false)
    private Integer sumId;
    @TableField(exist = false)
    private Role role;
}
