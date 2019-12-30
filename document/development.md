# 活动管理系统

## 数据库建表

### 活动表

* 名称
* 发起人
* 简介
* 活动地点
* 开始时间
* 结束时间
* 创建时间
* 最大人数
* 状态（0=未审核；1=通过；2=不通过）

### 参与人员表
* 活动编号
* 电话
* 角色（是否是注册用户）
* 相关信息

### 用户表
* 姓名
* 电话
* 用户名
* 密码
* 权限
* 状态（0=正常；1=封禁）
* 是否保密（0=公开；1=保密）
* 性别（0=男；1=女）
* 出生年月
* 介绍
* 积分

### 积分日志表
* 时间
* 原因
* 操作数量
* 操作目标（用户编号）

### 通知表
* 用户编号
* 信息内容
* 时间
* 状态（0=未读；1=已读）


## 模块及功能
### 超级管理员
* 管理普通管理员
### 管理员
* 赋予积分
* 封号
* 审核活动
* 删除活动


### 注册用户
* 获取信息
* 报名参加活动
* 管理活动：发布(创建人)、修改（创建人）、删除（创建人/管理员）、查询（所有人）
* 参与人员信息导出
* 增加参与人员（可批量导入）
* 短信通知


### 游客
* 报名参加活动


## 接口

### 获取所有活动列表

* URL: /activities
* METHOD: GET
* 参数：

| 属性名 | 类型   | 介绍                                |
| ------ | ------ | ----------------------------------- |
| page   | Number | 第几页                              |
| size   | Number | 每页几条数据                        |
| key    | String | 搜索关键字（空/活动名称/创建人名称) |

### 获取单个活动列表

* URL: /activity
* METHOD: GET
* 参数：

| 属性名 | 类型   | 介绍     |
| ------ | ------ | -------- |
| id     | Number | 活动编号 |



### 创建活动

* URL: /activity
* METHOD: Post
* 参数：


| 属性名     | 类型 | 介绍     |
| ---------- | ---- | -------- |
| name       | String | 名称     |
| creator    | Number | 发起人ID |
| address    | String | 活动地点 |
| introduce    | String | 简介 |
| startTime  | Date | 开始时间 |
| finishTime | Date | 结束时间 |
| max        | Number | 最大人数 |
| fields     | [String] | 自定义字段 |



### 修改活动

* URL: /activity
* METHOD: Post
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| name       | String   | 名称       |
| address    | String   | 活动地点   |
| introduce  | String   | 简介       |
| startTime  | Date     | 开始时间   |
| finishTime | Date     | 结束时间   |
| max        | Number   | 最大人数   |

### 删除活动
* URL:/ activity
* METHOD: DELETE
* 参数： 

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id       | Number   | 活动编号       |


### 查看所有参与人员
* URL:/ participants
* METHOD: GET
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id       | Number   | 活动编号       |
| page   | Number | 第几页                              |
| size   | Number | 每页几条数据                        |
| key       | String   | 搜索字段（可以为空）|


### 导出为excle表格
* URL:/export
* METHOD: GET
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id       | Number   | 活动编号       |
| participantsId| [Number]   | 参与人员编号|



### 导入excle表格
* URL:/inport
* METHOD:POST
* 参数：
| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id       | Number   | 活动编号       |
| participants| 文件   | 参与人员excle|


### 短信通知
* URL:/message
* METHOD:POST
* 参数：
| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id       | Number   | 活动编号       |

### 获取未审核活动
* URL: /admin/activities
* METHOD: GET
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| page   | Number | 第几页                              |
| size   | Number | 每页几条数据                        |

### 审核活动
* URL: /admin/activities
* METHOD: POST
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id       | Number   | 活动编号       |
| status       | Number   | 审核结果（1=通过；2=不通过）       |

### 发放积分
* URL：/admin/score
* METHOD：PUT
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id       | Number   | 用户id       |
| opera       | Number   | 数量       |

### 获取未读通知数量
* URL：/message
* METHOD：GET
* 参数：无

### 获取通知
* URL：/messages
* METHOD：GET
* 参数：无

### 获取用户信息
* URL：/user
* METHOD：GET
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| id | Number | 用户编号（选填/不填就是自己） |

### 编辑用户信息
* URL：/user
* METHOD：PUT
* 参数：

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| name | String | 姓名 |
| phoneNumber | Number | 电话 |
| username | String   | 用户名 |
| isSecret | Integer | 是否保密（0=公开；1=保密） |
| introduce | String | 介绍 |

### 修改密码

* URL：/password
* METHOD：PUT

| 属性名     | 类型     | 介绍       |
| ---------- | -------- | ---------- |
| name | String | 原始密码 |
| name | String | 新密码 |