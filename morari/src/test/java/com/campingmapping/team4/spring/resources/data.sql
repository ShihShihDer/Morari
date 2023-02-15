USE [campDB]
GO
/****** Object:  Table [dbo].[userprofiles]    Script Date: 2023/2/15 下午 01:02:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userprofiles](
	[uid] [binary](16) NOT NULL,
	[accountnonexpired] [bit] NULL,
	[accountnonlocked] [bit] NULL,
	[email] [varchar](50) NOT NULL,
	[iscredentialsnonexpired] [bit] NULL,
	[isenabled] [bit] NULL,
	[password] [varchar](255) NULL,
	[about] [varchar](max) NULL,
	[exp] [bigint] NULL,
	[gender] [int] NULL,
	[level] [int] NULL,
	[nickname] [varchar](255) NULL,
	[point] [bigint] NULL,
	[registerdata] [datetime2](6) NULL,
	[shot] [varchar](255) NULL,
	[subscribed] [bit] NULL,
	[firstname] [varchar](255) NULL,
	[lastname] [varchar](255) NULL,
	[address] [varchar](255) NULL,
	[birthday] [datetime2](6) NULL,
	[phone] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[userprofiles] ([uid], [accountnonexpired], [accountnonlocked], [email], [iscredentialsnonexpired], [isenabled], [password], [about], [exp], [gender], [level], [nickname], [point], [registerdata], [shot], [subscribed], [firstname], [lastname], [address], [birthday], [phone]) VALUES (0x0E26D599CBD643E181153B4CAA5C4C92, 1, 1, N'suc12345@gmail.com', 1, 1, NULL, N'暫時沒有留下什麼', 1, 0, 1, N'施育群', 100, CAST(N'2023-02-14T18:45:19.0840000' AS DateTime2), N'https://lh3.googleusercontent.com/a/AEdFTp5scEdzcnHImZ1NMzuk3al7ZhIzHVGXqp0M8scYHw=s96-c', 0, N'', N'', N'', NULL, N'')
GO
INSERT [dbo].[userprofiles] ([uid], [accountnonexpired], [accountnonlocked], [email], [iscredentialsnonexpired], [isenabled], [password], [about], [exp], [gender], [level], [nickname], [point], [registerdata], [shot], [subscribed], [firstname], [lastname], [address], [birthday], [phone]) VALUES (0x41600F10963D4F53A50E87E2907DF1BC, 1, 1, N'jackEEIT56@gmail.com', 1, 1, N'$2a$10$lWZOgn64ymCyhoTWHFG4o.TSS0SP0.iMi4UyB8rw.jMppULjgpaGC', N'暫時沒有留下什麼', 1, 0, 1, N'jackEEIT56@gmail.com', 100, CAST(N'2023-02-14T20:13:49.5900000' AS DateTime2), N'https://storage.googleapis.com/morariphoto/defaultshot', 0, N'', N'', N'', NULL, N'')
GO
INSERT [dbo].[userprofiles] ([uid], [accountnonexpired], [accountnonlocked], [email], [iscredentialsnonexpired], [isenabled], [password], [about], [exp], [gender], [level], [nickname], [point], [registerdata], [shot], [subscribed], [firstname], [lastname], [address], [birthday], [phone]) VALUES (0x82CEA0EE92A040E1BD07B1D6ED124C2A, 1, 1, N'sa', 1, 1, N'$2a$10$uI6O897G9..ynFE5gA4y5uZZaoOJXJTEJLeBYr8iQSr4Yp49ThEEu', N'想幹嘛就幹嘛', 999999, 0, 999999, N'燚~超-級=管=理-員~燚', 99999999, CAST(N'2023-02-15T12:57:49.0710000' AS DateTime2), N'https://storage.googleapis.com/morariphoto/adminshot', 0, N'camp', N'morari', N'morari', NULL, N'0912345678')
GO
INSERT [dbo].[userprofiles] ([uid], [accountnonexpired], [accountnonlocked], [email], [iscredentialsnonexpired], [isenabled], [password], [about], [exp], [gender], [level], [nickname], [point], [registerdata], [shot], [subscribed], [firstname], [lastname], [address], [birthday], [phone]) VALUES (0xA937C8516CCB4ECFB1A67996C98EBB4F, 1, 1, N'amuheropuipui@gmail.com', 1, 1, NULL, N'暫時沒有留下什麼', 1, 0, 1, N'英雄阿姆', 100, CAST(N'2023-02-14T18:45:31.8300000' AS DateTime2), N'https://lh3.googleusercontent.com/a/AEdFTp4rfmdp_-zrX21tsWPE3lIh9oZZC0fSNqc5fFEr=s96-c', 0, N'', N'', N'', NULL, N'')
GO
INSERT [dbo].[userprofiles] ([uid], [accountnonexpired], [accountnonlocked], [email], [iscredentialsnonexpired], [isenabled], [password], [about], [exp], [gender], [level], [nickname], [point], [registerdata], [shot], [subscribed], [firstname], [lastname], [address], [birthday], [phone]) VALUES (0xEE8033CD1A2B405A9A250AC8D9EC4AB0, 1, 1, N'camppingmapping@gmail.com', 1, 1, NULL, N'暫時沒有留下什麼', 1, 0, 1, N'Mapping Campping', 100, CAST(N'2023-02-14T18:45:41.9420000' AS DateTime2), N'https://lh3.googleusercontent.com/a/AEdFTp4ipAH1asNoQb_ICuvCgv7TJAK5X0_LugHWfjbu=s96-c', 0, N'', N'', N'', NULL, N'')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_jgbyjshnyxl47jrxpvbrbumgs]    Script Date: 2023/2/15 下午 01:02:49 ******/
ALTER TABLE [dbo].[userprofiles] ADD  CONSTRAINT [UK_jgbyjshnyxl47jrxpvbrbumgs] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
