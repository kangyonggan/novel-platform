DROP DATABASE IF EXISTS np;

CREATE DATABASE np
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE np;

-- ----------------------------
--  Table structure for tb_category
-- ----------------------------
DROP TABLE
IF EXISTS tb_category;

CREATE TABLE tb_category
(
  id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  code         VARCHAR(32)                           NOT NULL
  COMMENT '栏目代码',
  name         VARCHAR(32)                           NOT NULL
  COMMENT '栏目名称',
  type         VARCHAR(16)                           NOT NULL
  COMMENT '栏目类型',
  sort         INT(11)                               NOT NULL                    DEFAULT 0
  COMMENT '栏目排序(从0开始)',
  status       TINYINT                               NOT NULL                    DEFAULT 0
  COMMENT '状态:{0:可用, 1:禁用}',
  created_time TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '栏目表';
CREATE UNIQUE INDEX code_type_UNIQUE
  ON tb_category (code, type);
CREATE INDEX id_type
  ON tb_category (type);

-- ----------------------------
--  Table structure for tb_novel
-- ----------------------------
DROP TABLE
IF EXISTS tb_novel;

CREATE TABLE tb_novel
(
  id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  name          VARCHAR(32)                           NOT NULL
  COMMENT '书名',
  author        VARCHAR(32)                           NOT NULL
  COMMENT '作者',
  category_code VARCHAR(32)                           NOT NULL
  COMMENT '栏目代码',
  pic_url       VARCHAR(256)                          NOT NULL                    DEFAULT ''
  COMMENT '封面图片地址',
  code          INT(11)                               NOT NULL
  COMMENT '书籍代码',
  descp         VARCHAR(2048)                         NOT NULL
  COMMENT '描述',
  status        TINYINT                               NOT NULL                    DEFAULT 0
  COMMENT '状态:{0:可用, 1:禁用}',
  created_time  TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time  TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '书籍表';
CREATE UNIQUE INDEX code_UNIQUE
  ON tb_novel (code);
CREATE INDEX ix_category_code
  ON tb_novel (category_code);

-- ----------------------------
--  Table structure for tb_section
-- ----------------------------
DROP TABLE
IF EXISTS tb_section;

CREATE TABLE tb_section
(
  id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  code         INT(11)                               NOT NULL
  COMMENT '章节代码',
  title        VARCHAR(64)                           NOT NULL
  COMMENT '标题',
  content      LONGTEXT                              NOT NULL
  COMMENT '内容',
  novel_code   INT(11)                               NOT NULL
  COMMENT '小说代码',
  status       TINYINT                               NOT NULL                    DEFAULT 0
  COMMENT '状态:{0:可用, 1:禁用}',
  created_time TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '章节表';
CREATE UNIQUE INDEX code_UNIQUE
  ON tb_section (code);
CREATE INDEX ix_novel_code
  ON tb_section (novel_code);

INSERT INTO tb_category
(code, name, type, sort)
VALUES
  ('xuanhuan', '玄幻', 'NOVEL', 0),
  ('dushi', '都市', 'NOVEL', 1),
  ('xiuzhen', '修真', 'NOVEL', 2),
  ('lishi', '历史', 'NOVEL', 3),
  ('yanqing', '言情', 'NOVEL', 4),
  ('wangyou', '网游', 'NOVEL', 5),
  ('kehuan', '科幻', 'NOVEL', 6),
  ('qita', '其他', 'NOVEL', 7);