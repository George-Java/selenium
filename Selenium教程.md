# Selenium 教程

原始入口：https://www.byhy.net/auto/selenium/01/

目录：
1. [Selenium 原理与安装](https://www.byhy.net/auto/selenium/01/)
2. [选择元素的基本方法](https://www.byhy.net/auto/selenium/02/)
3. [操控元素的基本方法](https://www.byhy.net/auto/selenium/03/)
4. [css表达式-上篇](https://www.byhy.net/auto/selenium/css_1/)
5. [css表达式-下篇](https://www.byhy.net/auto/selenium/css_2/)
6. [frame切换/窗口切换](https://www.byhy.net/auto/selenium/frame/)
7. [选择框](https://www.byhy.net/auto/selenium/skills_1/)
8. [实战技巧](https://www.byhy.net/auto/selenium/skills_2/)
9. [Xpath选择器](https://www.byhy.net/auto/selenium/xpath_1/)

---

<!-- Source: https://www.byhy.net/auto/selenium/01/ -->

### 原理

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=1)

Selenium 是目前主流的 **Web浏览器 自动化方案** 。

通过它，我们可以写出自动化程序，像人一样在浏览器里操作web界面。 比如点击界面按钮，在文本框中输入文字 等操作。

而且还能从web界面获取信息。 比如获取 火车、汽车票务信息，招聘网站职位信息，财经网站股票价格信息 等等，然后用程序进行分析处理。

Selenium 的自动化原理是这样的

![image](https://www.byhy.net/cdn2/imgs/api/tut_20240113094425_19.png)

从上图可以看出：

我们写的自动化程序 需要使用 **客户端库**。

我们程序的自动化请求都是通过这个库里面的编程接口发送给浏览器。

比如，我们要模拟用户点击界面按钮， 自动化程序里面就应该 调用客户端库相应的函数， 就会发送 **点击元素** 的请求给 下方的 **浏览器驱动**。 然后，浏览器驱动再转发这个请求给浏览器。

这个自动化程序发送给浏览器驱动的请求 是HTTP请求。

客户端库从哪里来的？ 是Selenium组织提供的。

Selenium组织提供了多种 编程语言的Selenium客户端库， 包括 java，python，js， ruby等，方便不同编程语言的开发者使用。

我们只需要安装好客户端库，调用这些库，就可以发出自动化请求给浏览器咯。

**浏览器驱动** 也是一个独立的程序，是由浏览器厂商提供的， 不同的浏览器需要不同的浏览器驱动。 比如 Chrome浏览器和 火狐浏览器有 各自不同的驱动程序。

浏览器驱动接收到我们的自动化程序发送的界面操作请求后，会转发请求给浏览器， 让浏览器去执行对应的自动化操作。

浏览器执行完操作后，会将自动化的**结果**返回给浏览器驱动， 浏览器驱动再通过HTTP响应的消息返回给我们的自动化程序的客户端库。

自动化程序的客户端库 接收到响应后，将结果转化为 `数据对象` 返回给 我们的代码。

我们的程序就可以知道这次自动化操作的结果如何了。

我们再总结一下，selenium 自动化流程如下：

1. 自动化程序调用Selenium 客户端库函数（比如点击按钮元素）

2. 客户端库会发送Selenium 命令 给浏览器的驱动程序

3. 浏览器驱动程序接收到命令后 ,驱动浏览器去执行命令

4. 浏览器执行命令

5. 浏览器驱动程序获取命令执行的结果，返回给我们自动化程序

6. 自动化程序对返回结果进行处理

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 安装

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=2)

Selenium环境的安装主要就是安装3样东西： `客户端库` ，`浏览器 驱动` 和 `浏览器` 。

其中，浏览器的安装非常简单，就是应用程序安装，无需这里特别讲解。

主要讲一下 `客户端库` 和 `浏览器 驱动` 的安装。

#### 客户端库

不同的编程语言选择不同的Selenium客户端库。

对应我们Python语言来说，Selenium客户端库的安装非常简单，用 pip 命令即可。

打开 命令行程序，运行如下命令

```

pip install selenium

```

如果安装比较慢，可以指定使用国内的清华大学源

```

pip install selenium -i https://pypi.tuna.tsinghua.edu.cn/simple

```

#### 浏览器驱动

不同的浏览器 需要选择不同的浏览器驱动。

即使是同一种浏览器，自动化时， 使用的 浏览器驱动程序 也要 **版本匹配** 。

以前做selenium自动化，浏览器驱动 都是自己下载的。

商业浏览器 比如 Chrome, Edge, Firefox, Safari 都会自动更新版本， 而下载的浏览器驱动却不会自动更新。

这就会导致 selenium自动化一个常见的问题：浏览器驱动和浏览器的版本不匹配。

为了解决这个问题， 现在新版 Python Selenium 客户端库内置了一个 `selenium manager` 工具， 运行Selenium程序时， 它可以帮我们自动下载 浏览器和浏览器驱动。

所以，现在最简单的方法就是让 Selenium Mananger 自动帮你下载安装 浏览器驱动 。

##### Edge 驱动 自动安装

Windows上，Edge浏览器缺省就会有，所以 Windows上基于 Edge浏览器的自动化，环境搭建最简单

如果你是Mac用户，[点击这里](https://www.microsoft.com/edge)下载安装一下。

下面的代码, 可以自动化的 打开 Edge浏览器，并且自动化打开 白月黑羽网站。

这个代码后面会详细讲解，这里大家先了解 代码里面哪行是执行自动下载的 即可。

```

from selenium import webdriver

wd = webdriver.Edge() # 指定 Edge 浏览器，会自动下载驱动

wd.get('https://www.byhy.net')

input('按回车退出')

```

第3行代码里面的 `Edge` 指定了要自动化的是 Edge浏览器。

Selenium Mananger会自动检查系统是否安装了对应浏览器，如果没有就下载安装。

然后看是否有该浏览器 对应版本的驱动，如果没有就下载安装。

Selenium Mananger下载的驱动在本机的路径通常是：

```

# Windows
C:\Users\用户名\.cache\selenium\msedgedriver\win64\版本号\msedgedriver.exe

# Mac
/Users/用户名/.cache/selenium/msedgedriver/mac-arm64/版本号/msedgedriver

```

如果上面的这种安装方式 符合你的自动化需求，安装这一节后面的其它内容可以跳过去不用看，节省时间。

##### Chrome 驱动 自动安装

如果，你要自动化的是 Chrome浏览器，该怎么做呢？

如果电脑上还没有安装Chrome浏览器，可以[点击这里，下载安装谷歌浏览器](https://www.google.cn/chrome/) 。

然后，就可以运行代码了。比如，要使用Chrome浏览器，就这样写

```

from selenium import webdriver

wd = webdriver.Chrome() # 指定 Chrome 浏览器，会自动下载驱动

wd.get('https://www.byhy.net')

input('按回车退出')

```

海外用户，这样就可以了，和自动化Edge一样的方便。

但是国内用户，就可能有问题。

`selenium-manager` 对 Chrome浏览器驱动， 会去网址 `https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with-downloads.json` 查询各版本驱动下载网址，

这个网址在国内， 不同网络环境，有的能访问，有的不能访问，有的访问速度很慢 会卡顿很久。

`selenium-manager` 可以通过 设置环境变量 `SE_DRIVER_MIRROR_URL` 的值，指定驱动源的URL

比如，可以设置为 阿里的源 `https://cdn.npmmirror.com/binaries/chrome-for-testing`

Windows系统命令行窗口， 可以使用如下命令

```

set SE_DRIVER_MIRROR_URL=https://cdn.npmmirror.com/binaries/chrome-for-testing

```

Mac系统命令行窗口， 可以使用如下命令

```

export SE_DRIVER_MIRROR_URL=https://cdn.npmmirror.com/binaries/chrome-for-testing

```

也可以在代码最前面，加上如下代码，通过设置环境变量，指定使用国内的源

```

# 指定 Chrome Driver下载源；
import os
os.environ['SE_DRIVER_MIRROR_URL'] = 'https://cdn.npmmirror.com/binaries/chrome-for-testing'

```

这样设置后，Selenium根据该网址这个 文件 `https://cdn.npmmirror.com/binaries/chrome-for-testing/known-good-versions-with-downloads.json` 检查从哪里下载Chrome浏览器驱动。

这是国内网址，总应该没问题了吧？

但是，仍然可能有问题：

打开这个文件可以发现，里面的下载地址，都是 `storage.googleapis.com` 这个海外镜像的域名， 不是本站下载网址。

这些镜像文件只是单纯的同步文件，至于里面的内容包含的URL，不会相应的替换为本站的地址。

`storage.googleapis.com` 这个域名，目前实战班大部分学员使用没有问题。

如果还是有问题，可以使用后文介绍的 手动下载浏览器驱动的方法。

##### Chrome 驱动 手动下载

如果 Selenium Manager 不能自动下载安装 Chrome 浏览器驱动，可以 **手动下载** 。

Chrome浏览器安装好以后，接下来就是安装浏览器驱动 `ChromeDriver`

点击打开这个网址： [Chrome driver 国内镜像地址](https://registry.npmmirror.com/binary.html?path=chrome-for-testing/)

查看一下Chrome浏览器的版本， 选择当前的版本的浏览器对应的版本的驱动。

注意：浏览器和驱动的大版本号一定要匹配，小版本号尽量接近即可，不一定需要完全一致。

下载后，可以把 chromedriver.exe 放到环境变量 `PATH` 指定的其中一个目录里面，代码无需做任何修改。

因为Selenium会 优先在环境变量 `PATH` 的那些路径里面 找浏览器驱动。

如果你不想放在环境变量 `PATH` 中，就需要代码里面指定浏览器驱动路径，如下：

```

from selenium import webdriver

# 指定驱动路径
from selenium.webdriver.chrome.service import Service
wd = webdriver.Chrome(service=Service(r"d:\tools\chromedriver.exe"))

wd.get('https://www.byhy.net')

input('按回车退出')

```

手动下载Chrome 驱动的弊病前面讲过，就是当浏览器自动升级时，可能现有的驱动和其不匹配，需要重新手动下载

否则，selenium manager还会尝试下载对应版本的新的驱动，如果下载不成功，自动化就会失败。

### 代码讲解

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=3)

下面的代码, 可以自动化的 打开Chrome浏览器，并且自动化打开百度网站，可以大家可以运行一下看看。

```

from selenium import webdriver

# 创建 WebDriver 对象
wd = webdriver.Chrome()

# 调用WebDriver 对象的get方法 可以让浏览器打开指定网址
wd.get('https://www.byhy.net')

# 程序运行完会自动关闭浏览器，就是很多人说的闪退
# 这里加入等待用户输入，防止闪退
input('按回车退出') 

# 关闭浏览器窗口
wd.quit()

```

其中，第4行代码，就会运行浏览器驱动，并且运行Chrome浏览器

```

wd = webdriver.Chrome()

```

注意，等号右边 返回的是 WebDriver 类型的对象，我们可以通过这个对象来操控浏览器，比如 打开网址、选择界面元素等。

而第7行代码，就是使用 WebDriver 的 get 方法 打开网址

```

wd.get('https://www.byhy.net')

```

执行上面这行代码时，自动化程序就发起了 打开百度网址的 `请求消息` ，通过浏览器驱动， 给 Chrome浏览器。

Chome浏览器接收到该请求后，就会打开网址，通过浏览器驱动， 告诉自动化程序 打开成功。

### 常见问题

#### 关闭 chromedriver 日志

缺省情况下 chromedriver被启动后，会在屏幕上输出不少日志信息，如下

```

DevTools listening on ws://127.0.0.1:19727/devtools/browser/c19306ca-e512-4f5f-b9c7-f13aec506ab7
[21564:14044:0228/160456.334:ERROR:device_event_log_impl.cc(211)] [16:04:56.333] Bluetooth: bluetooth_adapter_winrt.cc:1072 Getting Default Adapter failed.

```

可以这样关闭

```

from selenium import webdriver

# 加上参数，禁止 chromedriver 日志写屏
options = webdriver.ChromeOptions()
options.add_experimental_option(
    'excludeSwitches', ['enable-logging'])

# 这里指定 options 参数
wd = webdriver.Chrome(options=options)

```

Edge浏览器驱动，也可以使用这个参数，比如

```

options = webdriver.EdgeOptions() # 注意：这里是 EdgeOptions
options.add_experimental_option(
    'excludeSwitches', ['enable-logging'])

wd = webdriver.Edge(options=options)

```

#### 浏览器首页显示防病毒重置设置

有的朋友的电脑上Selenium自动化时，浏览器开始显示如下

![image](https://www.byhy.net/cdn2/imgs/api/tut_20220226101749_73.png)

可以这样解决：

- 命令行输入 `regedit` ，运行注册表编辑器

- 在左边的目录树找到 `HKEY_CURRENT_USER\Software\Google\Chrome`

- 删除其下的 `TriggeredReset` 子项

- 关闭 注册表编辑器

### 扩展知识

浏览器和驱动之间的接口是各浏览器厂商私有的，通常我们无需关心。

喜欢刨根问底的朋友，可以参考 
[这个链接，了解 `Chrome浏览器` 和 `浏览器驱动` 之间的接口](https://chromedevtools.github.io/devtools-protocol/)

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 课后练习

根据教程，安装好 Selenium 自动化环境

然后需要大家按照下面的步骤安装一个练习自动化的网站系统 bysms

[请大家点击这里，按照说明下载、安装、运行 白月SMS系统](https://www.byhy.net/prac/pub/info/bysms)

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

---

<!-- Source: https://www.byhy.net/auto/selenium/02/ -->

## 选择元素的基本方法

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=4)

[请点击这里](https://www.byhy.net/cdn2/files/selenium/stock1.html)，打开我们的教学示例页面

如果我们想自动化输入 `股票名称` ，怎么做呢？

这就是在网页中，操控界面元素。

web界面自动化，要操控元素，首先需要 `选择` 界面元素 ，或者说 `定位` 界面元素

就是 先告诉浏览器，你要操作 `哪个` 界面元素， 让它找到你要操作的界面元素。

我们必须要让浏览器 **先找到元素，然后，才能操作元素**。

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 选择元素的方法

对应web自动化来说， 就是要告诉浏览器，你要操作的界面元素是什么。

那么，怎么告诉浏览器 呢？

方法就是：告诉浏览器，你要操作的这个 web 元素的 `特征` 。

就是告诉浏览器，这个元素它有什么与众不同的地方，可以让浏览器一下子找到它。

元素的特征怎么查看？

可以使用浏览器的 `开发者工具栏` 帮我们查看、选择 web 元素。

请大家用chrome浏览器访问百度，按F12后，点击下图箭头处的 `Elements` 标签，即可查看页面对应的HTML 元素

然后，再点击 最左边的图标，如下所示

之后，鼠标在界面上点击哪个元素，就可以查看 **该元素对应的html标签** 了。

比如，前面的图的高亮处，就是百度搜索输入框 对应的 input元素。

### 根据 id属性 选择元素

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=5)

[请大家点击这里](https://www.byhy.net/cdn2/files/selenium/stock1.html)，打开我们的教学示例页面

页面上有个输入股票名称的输入框，使用鼠标右键菜单 查看该 input元素，会发现它有一个属性叫id。

![](https://www.byhy.net/cdn2/imgs/api/tut_20220228095435_90.png)

我们可以把 id 想象成元素的编号， 是用来在html中标记该元素的。

根据规范， 如果元素有id属性 ，这个id 必须是当前html中唯一的。

所以如果元素有id， 根据id选择元素是最简单高效的方式。

这里，股票名称输入框 元素的 id值为 kw

下面的代码，可以自动化在浏览器中 访问我们的股票搜索网站，并且在输入框中搜索 `通讯` 。

大家可以运行一下看看。

```

from selenium import webdriver
from selenium.webdriver.common.by import By

# 创建 WebDriver 对象
wd = webdriver.Chrome()

# 调用WebDriver 对象的get方法 可以让浏览器打开指定网址
wd.get('https://www.byhy.net/cdn2/files/selenium/stock1.html')

# 根据id选择元素，返回的就是该元素对应的WebElement对象
element = wd.find_element(By.ID, 'kw')

# 通过该 WebElement对象，就可以对页面元素进行操作了
# 比如输入字符串到 这个 输入框里
element.send_keys('通讯\n')

input('按回车退出') 

```

其中

```

wd = webdriver.Chrome()

```

前面讲过，wd 赋值的是 WebDriver 类型的对象，我们可以通过这个对象来操控浏览器，比如 打开网址、选择界面元素等。

高亮的第11行代码

```

wd.find_element(By.ID, 'kw')

```

使用了 WebDriver 对象 的方法 `find_element` ，

这行代码运行是，就会发起一个请求通过 浏览器驱动 转发给浏览器，告诉它，需要选择一个id为 kw 的元素。

浏览器 找到id为kw的元素后，将结果通过 浏览器驱动 返回给 自动化程序， 所以 find\_element 方法会 返回一个 **WebElement 类型的对象**。

这个WebElement 对象可以看成是对应 `页面元素` 的遥控器。

我们通过这个WebElement对象，就可以 `操控` 对应的界面元素。

比如 ：

调用这个对象的 send\_keys 方法就可以在对应的元素中 输入字符串，

调用这个对象的 click 方法就可以 **点击** 该元素。

如果根据 传入的ID，找不到这样的元素，find\_element 方法就会抛出 `selenium.common.exceptions.NoSuchElementException` 异常

### 注意：find\_element写法

Selenium 升级到版本 4 以后， 下面这种 `find_element_by_xxx` 方法都作为过期不赞成的写法

```

# 初始化代码 ....

wd.find_element_by_id('username').send_keys('byhy')
wd.find_element_by_class_name('password').send_keys('sdfsdf')
wd.find_element_by_tag_name('input').send_keys('sdfsdf')
wd.find_element_by_css_selector('button[type=submit]').click()

```

运行会有告警，所以现在都要写成下面这种格式

```

from selenium.webdriver.common.by import By

# 初始化代码 ....

wd.find_element(By.ID, 'username').send_keys('byhy')
wd.find_element(By.CLASS_NAME, 'password').send_keys('sdfsdf')
wd.find_element(By.TAG_NAME, 'input').send_keys('sdfsdf')
wd.find_element(By.CSS_SELECTOR,'button[type=submit]').click()

```

### 根据 class属性、tag名 选择元素

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=6)

#### 根据 class属性 选择元素

web自动化的难点和重点之一，就是如何 `选择` 我们想要操作的web页面元素。

除了根据元素的id ，我们还可以根据元素的 `class` 属性选择元素。

就像一个 学生张三 可以定义类型为 中国人 或者 学生一样， 中国人 和 学生 都是 张三 的 类型。

元素也有类型， class 属性就用来标志着元素 `类型` ，

请大家 [点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/sample1.html)

这个网址对应的html内容 有如下的部分

```

    <body>
        
        <div class="plant"><span>土豆</span></div>
        <div class="plant"><span>洋葱</span></div>
        <div class="plant"><span>白菜</span></div>

        <div class="animal"><span>狮子</span></div>
        <div class="animal"><span>老虎</span></div>
        <div class="animal"><span>山羊</span></div>

    </body>

```

所有的植物元素都有个class属性 值为 plant。

所有的动物元素都有个class属性 值为 animal。

如果我们要选择 **所有的 动物**， 就像下面可以这样写，

```

wd.find_elements(By.CLASS_NAME, 'animal')

```

注意element后面多了个s

**注意**

find\_elements 返回的是找到的符合条件的 `所有` 元素 (这里有3个元素)， 放在一个 `列表` 中返回。

而如果我们使用 `wd.find_element` (注意少了一个s) 方法， 就只会返回 **第一个** 元素。

大家可以运行如下代码看看。

```

from selenium import webdriver
from selenium.webdriver.common.by import By

# 创建 WebDriver 实例对象，指明使用chrome浏览器驱动
wd = webdriver.Chrome()

# WebDriver 实例对象的get方法 可以让浏览器打开指定网址
wd.get('https://www.byhy.net/cdn2/files/selenium/sample1.html')

# 根据 class name 选择元素，返回的是 一个列表
# 里面 都是class 属性值为 animal的元素对应的 WebElement对象
elements = wd.find_elements(By.CLASS_NAME, 'animal')

# 取出列表中的每个 WebElement对象，打印出其text属性的值
# text属性就是该 WebElement对象对应的元素在网页中的文本内容
for element in elements:
    print(element.text)

input('按回车退出')     

```

首先，大家要注意： 通过 WebElement 对象的 `text属性` 可以获取该元素 在网页中的文本内容。

所以 下面的代码，可以打印出 element 对应 网页元素的 文本

```

print(element.text)

```

如果我们把

```

elements = wd.find_elements(By.CLASS_NAME, 'animal')

```

去掉一个s ，改为

```

element = wd.find_element(By.CLASS_NAME, 'animal')
print(element.text)

```

那么返回的就是第一个class 属性为 animal的元素， 也就是这个元素

```

<div class="animal"><span>狮子</span></div>

```

就像一个 学生张三 可以定义有 `多个` 类型： 中国人 和 学生 ， 中国人 和 学生 都是 张三 的 类型。

元素也可以有 `多个class类型` ，多个class类型的值之间用 `空格` 隔开，比如

```

<span class="chinese student">张三</span>

```

注意，这里 span元素 有两个class属性，分别 是 chinese 和 student， 而不是一个 名为 `chinese student` 的属性。

我们要用代码选择这个元素，可以指定任意一个class 属性值，都可以选择到这个元素，如下

```

element = wd.find_elements(By.CLASS_NAME,'chinese')

```

或者

```

element = wd.find_elements(By.CLASS_NAME,'student')

```

而不能这样写

```

element = wd.find_elements(By.CLASS_NAME,'chinese student')

```

#### 根据 tag 名 选择元素

类似的，我们可以通过指定 参数为 `By.TAG_NAME` ，选择所有的tag名为 div的元素，如下所示

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/sample1.html')

# 根据 tag name 选择元素，返回的是 一个列表
# 里面 都是 tag 名为 div 的元素对应的 WebElement对象
elements = wd.find_elements(By.TAG_NAME, 'div')

# 取出列表中的每个 WebElement对象，打印出其text属性的值
# text属性就是该 WebElement对象对应的元素在网页中的文本内容
for element in elements:
    print(element.text)

input('按回车退出')     

```

#### find\_element 和 find\_elements 的区别

使用 `find_elements` 选择的是符合条件的 `所有` 元素， 如果没有符合条件的元素， `返回空列表`

使用 `find_element` 选择的是符合条件的 `第一个` 元素， 如果没有符合条件的元素， `抛出 NoSuchElementException 异常`

### 通过WebElement对象选择元素

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=7)

不仅 WebDriver对象有 选择元素 的方法， WebElement对象 也有选择元素的方法。

WebElement对象 也可以调用 `find_elements`， `find_element` 之类的方法

WebDriver 对象 选择元素的范围是 整个 web页面， 而

WebElement 对象 选择元素的范围是 该元素的内部。

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/sample1.html')

element = wd.find_element(By.ID,'container')

# 限制 选择元素的范围是 id 为 container 元素的内部。
spans = element.find_elements(By.TAG_NAME, 'span')
for span in spans:
    print(span.text)

input('按回车退出')     

```

输出结果就只有

```

内层11
内层12
内层21

```

后面会学到css选择元素，这样的代码

```

element.find_element(By.CSS_SELECTOR, "div > div > span")

```

限制的是最后一个 `span` 必须在 element内部，

而前面的 `div > div` **不一定** 需要在 在 element内部

### 等待界面元素出现

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=8)

在我们进行网页操作的时候， 有的元素内容不是可以立即出现的， 可能会等待一段时间。

比如 我们的股票搜索示例页面， 搜索一个股票名称， 我们点击搜索后， 浏览器需要把这个搜索请求发送给服务器， 服务器进行处理后，再把搜索结果返回给我们。

所以，从点击搜索到得到结果，需要一定的时间，

只是通常 服务器的处理比较快，我们感觉好像是立即出现了搜索结果。

搜索的每个结果 对应的界面元素 其ID 分别是数字 1， 2 ，3， 4 。。。

我们可以先用如下代码 将 第一个搜索结果里面的文本内容 打印出来

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/stock1.html')

element = wd.find_element(By.ID, 'kw')

element.send_keys('通讯\n')


# 返回页面 ID为1 的元素
element = wd.find_element(By.ID,'1')
# 打印该元素的文字内容
print(element.text)

input('按回车退出')     

```

如果大家去运行一下，就会发现有如下异常抛出

```

selenium.common.exceptions.NoSuchElementException: Message: no such element: Unable to locate element: {"method":"css selector","selector":"[id="1"]"}

```

`NoSuchElementException` 的意思就是在当前的网页上 找不到该元素， 就是找不到 id 为 1 的元素。

为什么呢？

因为我们的代码执行的速度比 网站响应的速度 快。

网站还没有来得及 返回搜索结果，我们就执行了如下代码

```

element = wd.find_element(By.ID, '1')

```

在那短暂的瞬间， 网页上是没有用 id为1的元素的 （因为还没有搜索结果呢）。自然就会报告错误 id为1 的元素不存在了。

那么怎么解决这个问题呢？

很多聪明的读者可以想到， 点击搜索后， 用sleep 来 等待几秒钟， 等百度服务器返回结果后，再去选择 id 为1 的元素， 就像下面这样

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/stock1.html')

element = wd.find_element(By.ID, 'kw')

element.send_keys('通讯\n')

# 等待 1 秒
from time import sleep
sleep(1)

element = wd.find_element(By.ID,'1')
print(element.text)

input('按回车退出')     

```

大家可以运行一下，基本是可以的，不会再报错了。

但是这样的方法 有个很大的问题，就是：设置等待多长时间合适呢？

这次百度网站反应可能比较快，我们等了一秒钟就可以了。

但是谁知道下次他的反应是不是还这么快呢？百度也曾经出现过服务器瘫痪的事情。

可能有的读者说，我干脆sleep比较长的时间， 等待 20 秒， 总归可以了吧？

这样也有很大问题，假如一个自动化程序里面需要10次等待， 就要花费 200秒。 而可能大部分时间， 服务器反映都是很快的，根本不需要等20秒， 这样就造成了大量的时间浪费了。

Selenium提供了一个更合理的解决方案，是这样的：

当发现元素没有找到的时候， **并不立即返回** 找不到元素的错误。

而是周期性（每隔半秒钟）重新寻找该元素，直到该元素找到，

或者超出指定最大等待时长，这时才 抛出异常（如果是 `find_elements` 之类的方法， 则是返回空列表）。

Selenium 的 Webdriver 对象 有个方法叫 `implicitly_wait` ，可以称之为 `隐式等待` ，或者 `全局等待` 。

该方法接受一个参数， 用来指定 最大等待时长。

如果我们 加入如下代码

```

wd.implicitly_wait(10)

```

那么后续所有的 `find_element` 或者 `find_elements` 之类的方法调用 都会采用上面的策略：

如果找不到元素， 每隔 半秒钟 再去界面上查看一次， 直到找到该元素， 或者 过了10秒 最大时长。

这样，我们的百度搜索的例子的最终代码如下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()
wd.implicitly_wait(10)

wd.get('https://www.byhy.net/cdn2/files/selenium/stock1.html')

element = wd.find_element(By.ID, 'kw')

element.send_keys('通讯\n')


# 返回页面 ID为1 的元素
element = wd.find_element(By.ID,'1')

print(element.text)

input('按回车退出')     

```

大家再运行一下，可以发现不会有错误了。

那么是不是有了 `implicitwait` ， 可以彻底不用sleep了呢？

不是的，有的时候我们等待元素出现，仍然需要sleep。

[请点击这里，观看白月黑羽给实战班学员讲解什么时候必须还是要sleep](https://www.bilibili.com/video/BV1Z4411o7TA?p=30)

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 课后练习

打开 第一节课后练习 下载的 白月SMS系统的测试用例文档（也在白月SMS系统下载网盘地址里面），白月SMS系统的 `安装步骤` 可以参考 `课程1的课后练习`

完成用例 `UI-0101` 的自动化

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

### 补充练习

实战班学员请联系老师获取补充练习题

---

<!-- Source: https://www.byhy.net/auto/selenium/03/ -->

## 操控元素的基本方法

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=9)

选择到元素之后，我们的代码会返回元素对应的 WebElement对象，通过这个对象，我们就可以 `操控` 元素了。

操控元素通常包括

- 点击元素

- 在元素中输入字符串，通常是对输入框这样的元素

- 获取元素包含的信息，比如文本内容，元素的属性

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 点击元素

`点击元素` 非常简单，就是调用元素WebElement对象的 click方法。前面我们已经学过。

这里我们要补充讲解一点。

当我们调用 WebElement 对象的 click 方法去点击 元素的时候， 浏览器接收到自动化命令，点击的是该元素的 `中心点` 位置 。

例如，对于下面的这样一个元素

我们要点击 添加客户 这个按钮，既可以点击 右边对应的 绿色框子总的button 元素 ，也可以点击红色框子中的span元素 。

因为这两个元素的中心点都是 button 内部，都是有效点击区域

### 输入框

`输入字符串` 也非常简单，就是调用元素WebElement对象的send\_keys方法。前面我们也已经学过。

如果我们要 把输入框中已经有的内容清除掉，可以使用WebElement对象的clear方法

请大家[点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/test3.html)

并且按F12，观察HTML的内容

我们要写一个自动化程序：要求在输入框中填入姓名：白月黑羽。

而且要做到输入框中已经有的提示字符，需要先 `清除掉`

代码应该如下

```

element = wd.find_element(By.ID, "input1")

element.clear() # 清除输入框已有的字符串
element.send_keys('白月黑羽') # 输入新字符串

```

### 获取元素信息

#### 获取元素的文本内容

上一章，我们已经知道，通过WebElement对象的 `text` 属性，可以获取元素 `展示在界面上的` 文本内容。

比如

```

element = wd.find_element(By.ID, 'animal')
print(element.text)

```

#### 获取元素属性

通过WebElement对象的 `get_attribute` 方法来获取元素的属性值

比如要获取元素属性class的值，就可以使用 `element.get_attribute('class')`

如下：

```

element = wd.find_element(By.ID, 'input_name')
print(element.get_attribute('class'))

```

执行完自动化代码，如果想关闭浏览器窗口可以调用WebDriver对象的 quit 方法，像这样 wd.quit()

#### 获取整个元素对应的HTML

要获取整个元素对应的HTML文本内容，可以使用 `element.get_attribute('outerHTML')`

如果，只是想获取某个元素 `内部` 的HTML文本内容，可以使用 `element.get_attribute('innerHTML')`

#### 获取输入框里面的文字

对于input输入框的元素，要获取里面的输入文本，用text属性是不行的，这时可以使用 `element.get_attribute('value')`

比如

```

element = wd.find_element(By.ID, "input1")
print(element.get_attribute('value')) # 获取输入框中的文本

```

#### 获取元素文本内容2

通过WebElement对象的 `text` 属性，可以获取元素 `展示在界面上的` 文本内容。

但是，有时候，元素的文本内容没有展示在界面上，或者没有完全完全展示在界面上。 这时，用WebElement对象的text属性，获取文本内容，就会有问题。

出现这种情况，可以尝试使用 `element.get_attribute('innerText')` ，或者 `element.get_attribute('textContent')`

使用 innerText 和 textContent 的区别是，前者只显示元素可见文本内容，后者显示所有内容（包括display属性为none的部分）

具体可以[参考这里](https://stackoverflow.com/questions/35213147/difference-between-textcontent-vs-innertext)

如果您了解web前端开发，可以知晓一下：

get\_attribute 调用本质上就是调用 HTMLElement 对象的属性

比如

element.get\_attribute('value') 等价于js里面的 element.value

element.get\_attribute('innerText') 等价于js里面的 element.innerText

### 课后练习

打开前面练习下载的 白月SMS系统的测试用例文档，白月SMS系统的 `安装步骤` 可以参考 `课程1的课后练习`

完成用例 `UI-0102` 和 `UI-0103` 的自动化

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

### 补充练习

实战班学员请联系老师获取补充练习题

---

<!-- Source: https://www.byhy.net/auto/selenium/css_1/ -->

## css表达式-上篇

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=10)

前面我们看到了根据 id、class属性、tag名 选择元素。

如果我们要选择的 元素 没有id、class 属性，或者有些我们不想选择的元素 也有相同的 id、class属性值，怎么办呢？

这时候我们通常可以通过 `CSS selector (选择器)` 语法选择元素。

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### CSS Selector 语法选择元素原理

HTML中经常要 为 某些元素 指定 **显示效果**，比如 前景文字颜色是红色， 背景颜色是黑色， 字体是微软雅黑等。

那么CSS必须告诉浏览器：要 **选择哪些元素** ， 来使用这样的显示风格。

比如 ，[下图中](https://www.byhy.net/cdn2/files/selenium/sample1.html)，为什么狮子老虎山羊会显示为红色呢？

![image](https://www.byhy.net/cdn2/imgs/gh/36257654_62668791-c36b6c00-b9bf-11e9-8196-8df5c8ffd890.png)

因为蓝色框里面用css 样式，指定了class 值为animal的元素，要显示为红色。

其中 蓝色框里面的 .animal 就是 CSS Selector ，或者说 CSS 选择器。

CSS Selector 语法就是用来选择元素的。

既然 CSS Selector 语法 天生就是浏览器用来选择元素的，selenium自然就可以使用它用在自动化中，去选择要操作的元素了。

只要 CSS Selector 的语法是正确的， Selenium 就可以选择到该元素。

CSS Selector 非常强大，学习Selenium Web自动化一定要学习 CSS Selector

通过 CSS Selector 选择单个元素的方法是

```

find_element(By.CSS_SELECTOR, CSS Selector参数)

```

选择所有元素的方法是

```

find_elements(By.CSS_SELECTOR, CSS Selector参数)

```

CSS Selector 选择元素非常灵活强大， 大家可以从下面的例子看出来。

### 根据 tag名、id、class 选择元素

CSS Selector 同样可以根据tag名、id 属性和 class属性 来 选择元素，

根据 tag名 选择元素的 CSS Selector 语法非常简单，直接写上tag名即可，

比如 要选择 所有的tag名为div的元素，就可以是这样

```

elements = wd.find_elements(By.CSS_SELECTOR, 'div')

```

等价于

```

elements = wd.find_elements(By.TAG_NAME, 'div')

```

---

根据id属性 选择元素的语法是在id号前面加上一个井号： `#id值`

比如 [请点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/sample1.html)

有下面这样的元素：

```

<input  type="text" id='searchtext' />

```

就可以使用 `#searchtext` 这样的 CSS Selector 来选择它。

比如，我们想在 `id 为 searchtext` 的输入框中输入文本 `你好` ，完整的Python代码如下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/sample1.html')

element = wd.find_element(By.CSS_SELECTOR, '#searchtext')
element.send_keys('你好')

```

---

根据class属性 选择元素的语法是在 class 值 前面加上一个点： `.class值`

比如 这个网址 https://www.byhy.net/cdn2/files/selenium/sample1.html

要选择**所有** class 属性值为 animal的元素 动物 除了这样写

```

elements = wd.find_elements(By.CLASS_NAME, 'animal')

```

还可以这样写

```

elements = wd.find_elements(By.CSS_SELECTOR, '.animal')

```

因为是选择 `所有` 符合条件的 ，所以用 `find_elements` 而不是 `find_element`

### 选择 子元素 和 后代元素

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=11)

CSS 选择器 可以 **限定选择的上级范围** ，也就是选择某个元素的 **子元素** 和 **后代元素** 。

什么是 **子元素** 和 **后代元素** 呢？

HTML中， 元素 内部可以 **包含其他元素**， 比如 下面的 HTML片段

```

<div id='container'>
    
    <div id='layer1'>
        <div id='inner11'>
            <span>内层11</span>
        </div>
        <div id='inner12'>
            <span>内层12</span>
        </div>
    </div>

    <div id='layer2'>
        <div id='inner21'>
            <span>内层21</span>
        </div>
    </div>
    
</div>

```

下面的一段话有些绕口， 请 大家细心 阅读：

id 为 `container` 的div元素 包含了 id 为 `layer1` 和 `layer2` 的两个div元素。

这种包含是直接包含， 中间没有其他的层次的元素了。 所以 我们把 id 为 `layer1` 和 `layer2` 的两个div元素 称之为 id 为 `container` 的div元素 的 **直接子元素** ，简称 **子元素** 。 这里说的 `子` 是指 `孩子` 的意思。

反之，把 id 为 `container` 的div元素 称之为 id 为 `layer1` 和 `layer2` 的两个div元素 的 **父元素**

而对于 id 为 `container` 的div元素来说， id 为 `inner11` 、`inner12` 、`inner21` 的元素 和 两个 `span类型的元素` 都不是 它的直接子元素， 因为中间隔了 几层。

虽然不是直接子元素， 但是 它们还是在 `container` 的内部， 可以称之为它 的 **后代元素**。

反之， 把 把 id 为 `container` 的div元素 称之为 id 为 `inner11` 、`inner12` 、`inner21` 的元素 的 **祖先元素**

后代元素也包括了直接子元素， 比如 id 为 `layer1` 和 `layer2` 的两个div元素 也可以说 是 id 为 `container` 的div元素 的 **直接子元素，同时也是后代子元素**

如果 `元素2` 是 `元素1` 的 直接子元素， 
CSS Selector 选择子元素的语法是这样的

```

元素1 > 元素2

```

中间用一个大于号 （我们可以理解为箭头号）

注意，最终选择的元素是 **元素2**， 并且要求这个 **元素2** 是 **元素1** 的直接子元素

也支持更多层级的选择， 比如

```

元素1 > 元素2 > 元素3 > 元素4

```

就是选择 `元素1` 里面的子元素 `元素2` 里面的子元素 `元素3` 里面的子元素 `元素4` ， 最终选择的元素是 **元素4**

如果 `元素2` 是 `元素1` 的 后代元素， 
CSS Selector 选择后代元素的语法是这样的

```

元素1   元素2

```

中间是一个或者多个空格隔开

最终选择的元素是 **元素2** ， 并且要求这个 **元素2** 是 **元素1** 的后代元素。

也支持更多层级的选择， 比如

```

元素1   元素2   元素3  元素4

```

最终选择的元素是 **元素4**

CSS 支持 大于号和 空格 混合使用，比如

```

元素1 >  元素2   元素3 > 元素4

```

其中每个元素的写法 可以是 **复合写法** ，比如

```

span.date  // 选择 class 值有 date 的 span 元素

div#bottom // 选择 id 为 bottom 的 div 元素

div#bottom.date // 选择 id 为 bottom, class 值有 date, 的 div 元素

```

[点击这个链接，打开水浒人物网页](https://www.byhy.net/cdn2/files/selenium/shuihu.html)，结合视频讲解学习

### 根据属性选择

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=12)

id、class 都是web元素的 `属性` ，因为它们是很常用的属性，所以css选择器专门提供了根据 id、class 选择的语法。

那么其他的属性呢？

比如 [点击打开这个网页](https://www.byhy.net/cdn2/files/selenium/sample1.html)， 里面底部的这个元素

```

<a href="http://www.miitbeian.gov.cn">苏ICP备88885574号</a>

```

里面根据 href选择，可以用css 选择器吗？

当然可以！

css 选择器支持通过任何属性来选择元素，语法是用一个方括号 `[]` 。

比如要选择上面的a元素，就可以使用 `[href="http://www.miitbeian.gov.cn"]` 。

这个表达式的意思是，选择 属性href值为 `http://www.miitbeian.gov.cn` 的元素。

完整代码如下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/sample1.html')

# 根据属性选择元素
element = wd.find_element(By.CSS_SELECTOR, '[href="http://www.miitbeian.gov.cn"]')

# 打印出元素对应的html
print(element.get_attribute('outerHTML'))

```

当然，前面可以加上标签名的限制，比如 `div[class='SKnet']` 表示 选择所有 标签名为div，且class属性值为SKnet的元素。

属性值用单引号，双引号都可以。

根据属性选择，还可以不指定属性值，比如 `[href]` ， 表示选择 所有 具有 属性名 为href 的元素，不管它们的值是什么。

CSS 还可以选择 属性值 `包含` 某个字符串 的元素

比如， 要选择a节点，里面的href属性包含了 miitbeian 字符串，就可以这样写

```

a[href*="miitbeian"]

```

还可以 选择 属性值 以某个字符串 `开头` 的元素

比如， 要选择a节点，里面的href属性以 http 开头 ，就可以这样写

```

a[href^="http"]

```

还可以 选择 属性值 以某个字符串 `结尾` 的元素

比如， 要选择a节点，里面的href属性以 gov.cn 结尾 ，就可以这样写

```

a[href$="gov.cn"]

```

如果一个元素具有多个属性

```

<div class="misc" ctype="gun">沙漠之鹰</div>

```

CSS 选择器 可以指定 选择的元素要 同时具有多个属性的限制，像这样 `div[class=misc][ctype=gun]`

### 验证 CSS Selector

那么我们怎么验证 CSS Selector 的语法是否正确选择了我们要选择的元素呢？

当然可以像下面这样，写出Python代码，运行看看，能否操作成功

```

element = wd.find_element(By.CSS_SELECTOR, '#searchtext')
element.input('输入的文本')

```

如果成功，说明选择元素的语法是正确的。

但是这样做的问题就是：太麻烦了。

当我们进行自动化开发的时候，有大量选择元素的语句，都要这样一个个的验证，就非常耗时间。

由于 CSS Selector 是浏览器直接支持的，可以在浏览器 **开发者工具栏** 中验证。

比如我们使用Chrome浏览器打开 https://www.byhy.net/cdn2/files/selenium/sample1.html

按F12 打开 开发者工具栏

如果我们要验证 下面的表达式

```

#bottom > .footer2  a

```

能否选中 这个元素

```

<a href="http://www.miitbeian.gov.cn">苏ICP备88885574号</a>

```

可以这样做：

点击 Elements 标签后， 同时按 Ctrl 键 和 F 键， 就会出现下图箭头处的 搜索框

我们可以在里面输入任何 CSS Selector 表达式 ，如果能选择到元素， 右边的的红色方框里面就会显示出类似 
`2 of 3` 这样的内容。

of 后面的数字表示这样的表达式 `总共选择到几个元素`

of 前面的数字表示当前黄色高亮显示的是 `其中第几个元素`

上图中的 `1 of 1` 就是指 ： CSS 选择语法 `#bottom > .footer2 a`

在当前网页上共选择到 1 个元素， 目前高亮显示的是第1个。

如果我们输入 `.plant` 就会发现，可以选择到3个元素

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 课后练习

打开前面练习下载的 白月SMS系统的测试用例文档，白月SMS系统的 `安装步骤` 可以参考 `课程1的课后练习`

完成用例 `UI-0103` 的自动化，注意 选择元素都 尽量 使用 CSS 选择器

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

### 补充练习

实战班学员请联系老师获取补充练习题

---

<!-- Source: https://www.byhy.net/auto/selenium/css_2/ -->

## css表达式-下篇

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 组选择

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=13)

如果我们要 同时选择所有class 为 plant `和` class 为 animal 的元素。怎么办？

这种情况，css选择器可以 使用 `逗号` ，称之为 组选择 ，像这样

```

.plant , .animal

```

再比如，我们要同时选择所有tag名为div的元素 `和` id为BYHY的元素，就可以像这样写

```

div,#BYHY

```

对应的selenium代码如下

```

elements = wd.find_elements(By.CSS_SELECTOR, 'div,#BYHY')
for element in elements:
    print(element.text)

```

我们再看一个例子

打开这个网址 [请点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/sample1a.html)

我们要选择所有 唐诗里面的作者和诗名， 也就是选择所有 id 为 t1 里面的 `span 和 p 元素`

我们是不是应该这样写呢？

```

#t1 > span,p

```

不行哦，这样写的意思是 选择所有 `id 为 t1 里面的 span` 和 `所有的 p 元素`

只能这样写

```

#t1 > span , #t1 > p

```

另外注意：组选择结果列表中，选中元素排序， 不是 组表达式的次序， 而是符合这些表达式的元素，在HTML文档中的出现的次序。

### 按次序选择子节点

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=14)

[请点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/sample1b.html)

对应的html如下，关键信息如下

```

    <body>  
       <div id='t1'>
           <h3> 唐诗 </h3>
           <span>李白</span>
           <p>静夜思</p>
           <span>杜甫</span>
           <p>春夜喜雨</p>              
       </div>      
        
       <div id='t2'>
           <h3> 宋词 </h3>
           <span>苏轼</span>
           <p>赤壁怀古</p>
           <p>明月几时有</p>
           <p>江城子·乙卯正月二十日夜记梦</p>
           <p>蝶恋花·春景</p>
           <span>辛弃疾</span>
           <p>京口北固亭怀古</p>
           <p>青玉案·元夕</p>
           <p>西江月·夜行黄沙道中</p>
       </div>             

    </body>

```

#### 父元素的第n个子节点

我们可以指定选择的元素 `是父元素的第几个子节点`

使用 `nth-child`

比如，

我们要选择 唐诗 和宋词 的第一个 作者，

也就是说 选择的是 第2个子元素，并且是span类型

所以这样可以这样写 `span:nth-child(2)` ，

如果你不加节点类型限制，直接这样写 `:nth-child(2)`

就是选择所有位置为第2个的所有元素，不管是什么类型

学员对nth-child的含义很容易产生误解，[请点击这里，观看白月黑羽给实战班学员答疑讲解 nth-child](https://www.bilibili.com/video/BV1Z4411o7TA?p=29)

#### 父元素的倒数第n个子节点

也可以反过来， 选择的是父元素的 `倒数第几个子节点` ，使用 `nth-last-child`

比如：

```

p:nth-last-child(1)

```

就是选择第倒数第1个子元素，并且是p元素

#### 父元素的第几个某类型的子节点

我们可以指定选择的元素 是父元素的第几个 `某类型的` 子节点

使用 `nth-of-type`

比如，

我们要选择 唐诗 和宋词 的第一个 作者，

可以像上面那样思考：选择的是 第2个子元素，并且是span类型

所以这样可以这样写 `span:nth-child(2)` ，

还可以这样思考，选择的是 `第1个span类型` 的子元素

所以也可以这样写 `span:nth-of-type(1)`

#### 父元素的倒数第几个某类型的子节点

当然也可以反过来， 选择父元素的 `倒数第几个某类型` 的子节点

使用 `nth-last-of-type`

像这样

```

p:nth-last-of-type(2)

```

#### 奇数节点和偶数节点

如果要选择的是父元素的 `偶数节点`，使用 `nth-child(even)`

比如

```

p:nth-child(even)

```

如果要选择的是父元素的 `奇数节点`，使用 `nth-child(odd)`

```

p:nth-child(odd)

```

如果要选择的是父元素的 `某类型偶数节点`，使用 `nth-of-type(even)`

如果要选择的是父元素的 `某类型奇数节点`，使用 `nth-of-type(odd)`

### 兄弟节点选择

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=15)

#### 相邻兄弟节点选择

上面的例子里面，我们要选择 唐诗 和宋词 的第一个 作者

还有一种思考方法，就是选择 h3 `后面紧跟着的兄弟节点` span。

这就是一种 相邻兄弟 关系，可以这样写 `h3 + span`

表示元素 紧跟关系的 是 `加号`

#### 后续所有兄弟节点选择

如果要选择是 选择 h3 `后面所有的兄弟节点` span，可以这样写 `h3 ~ span`

更多CSS选择器的介绍，可以参考[CSS 选择器参考手册](http://www.w3school.com.cn/cssref/css_selectors.asp)

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 课后练习

打开前面练习下载的 白月SMS系统的测试用例文档，白月SMS系统的 `安装步骤` 可以参考 `课程1的课后练习`

完成用例 `UI-0105` 的自动化

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

### 补充练习

实战班学员请联系老师获取补充练习题

---

<!-- Source: https://www.byhy.net/auto/selenium/frame/ -->

## frame切换/窗口切换

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 切换到frame

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=16)

[请大家点击这里，打开这个链接](https://www.byhy.net/cdn2/files/selenium/sample2.html)

如果我们要 选择 下图方框中 所有的 蔬菜，使用css选择，怎么写表达式？

当然，要先查看到它们的html元素特征

大家可能会照旧写出如下代码：

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/sample2.html')

# 根据 class name 选择元素，返回的是 一个列表
elements = wd.find_elements(By.CLASS_NAME, 'plant')

for element in elements:
    print(element.text)

```

运行一下，你就会发现，运行结果打印内容为空白，说明没有选择到 class 属性值为 plant 的元素。

为什么呢？

因为仔细看，你可以发现， 这些元素是在一个叫 iframe的 元素中的。

这个 iframe 元素非常的特殊， 在html语法中，frame 元素 或者iframe元素的内部 会包含一个 **被嵌入的** 另一份html文档。

在我们使用selenium打开一个网页时， 我们的操作范围 缺省是当前的（最外层的） html ， 并不包含被嵌入的html文档里面的内容。

如果我们要 操作 被嵌入的 html 文档 中的元素， 就必须 `切换操作范围` 到 被嵌入的文档中。

怎么切换呢？

使用 WebDriver 对象的 switch\_to 属性，像这样

```

wd.switch_to.frame(frame_reference)

```

其中， frame\_reference 可以是 frame 元素的属性 name 或者 ID 。

比如这里，就可以填写 iframe元素的id 'frame1' 或者 name属性值 'innerFrame'。

像这样

```

wd.switch_to.frame('frame1')

```

或者

```

wd.switch_to.frame('innerFrame')

```

也可以填写frame 所对应的 WebElement 对象。

我们可以根据frame的元素位置或者属性特性，使用find系列的方法，选择到该元素，得到对应的WebElement对象

比如，这里就可以写

```

wd.switch_to.frame(wd.find_element(By.TAG_NAME, "iframe"))

```

然后，就可以进行后续操作frame里面的元素了。

上面的例子的正确代码如下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/sample2.html')


# 先根据name属性值 'innerFrame'，切换到iframe中
wd.switch_to.frame('innerFrame')

# 根据 class name 选择元素，返回的是 一个列表
elements = wd.find_elements(By.CLASS_NAME, 'plant')

for element in elements:
    print(element.text)

```

---

如果我们已经切换到某个iframe里面进行操作了，那么后续选择和操作界面元素 就都是在这个frame里面进行的。

这时候，如果我们又需要操作 **主html** （我们把最外层的html称之为 `主html` ） 里面的元素了呢？

怎么切换回原来的 `主html` 呢？

很简单，写如下代码即可

```

wd.switch_to.default_content()

```

例如，在上面 代码 操作完 frame里面的元素后， 需要 点击 `主html` 里面的按钮，就可以这样写

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()

wd.get('https://www.byhy.net/cdn2/files/selenium/sample2.html')


# 先根据name属性值 'innerFrame'，切换到iframe中
wd.switch_to.frame('innerFrame')

# 根据 class name 选择元素，返回的是 一个列表
elements = wd.find_elements(By.CLASS_NAME, 'plant')

for element in elements:
    print(element.text)

# 切换回 最外部的 HTML 中
wd.switch_to.default_content()

# 然后再 选择操作 外部的 HTML 中 的元素
wd.find_element_by_id('outerbutton').click()

wd.quit()


```

### 切换到新的窗口

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=17)

在网页上操作的时候，我们经常遇到，点击一个链接 或者 按钮，就会打开一个 `新窗口` 。

[请大家点击这里，打开这个链接](https://www.byhy.net/cdn2/files/selenium/sample3.html)

在打开的网页中，点击 链接 `访问bing网站` ， 就会弹出一个新窗口，访问bing网址。

如果我们用Selenium写自动化程序 **在新窗口里面 打开一个新网址**， 并且去自动化操作新窗口里面的元素，会有什么问题呢？

问题就在于，即使新窗口打开了， 这时候，我们的 WebDriver对象对应的 还是老窗口，自动化操作也还是在老窗口进行，

我们可以运行如下代码验证一下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

wd = webdriver.Chrome()
wd.implicitly_wait(10)

wd.get('https://www.byhy.net/cdn2/files/selenium/sample3.html')

# 点击打开新窗口的链接
link = wd.find_element(By.TAG_NAME, "a")
link.click()

# wd.title属性是当前窗口的标题栏 文本
print(wd.title)


```

运行完程序后，最后一行 打印当前窗口的标题栏 文本， 输出内容是

```

白月黑羽测试网页3

```

说明， 我们的 WebDriver对象指向的还是老窗口，否则的话，运行结果就应该新窗口的标题栏 "微软Bing搜索"

---

如果我们要到新的窗口里面操作，该怎么做呢？

可以使用Webdriver对象的switch\_to属性的 window方法，如下所示：

```

wd.switch_to.window(handle)

```

其中，参数handle需要传入什么呢？

WebDriver对象有window\_handles 属性，这是一个列表对象， 里面包括了当前浏览器里面**所有的窗口句柄**。

所谓句柄，大家可以想象成对应网页窗口的一个ID，

那么我们就可以通过 类似下面的代码，

```

for handle in wd.window_handles:
    # 先切换到该窗口
    wd.switch_to.window(handle)
    # 得到该窗口的标题栏字符串，判断是不是我们要操作的那个窗口
    if 'Bing' in wd.title:
        # 如果是，那么这时候WebDriver对象就是对应的该该窗口，正好，跳出循环，
        break

```

上面代码的用意就是：

我们依次获取 wd.window\_handles 里面的所有 句柄 对象， 并且调用 
wd.switch\_to.window(handle) 方法，切入到每个窗口，

然后检查里面该窗口对象的属性（可以是标题栏，地址栏），判断是不是我们要操作的那个窗口，如果是，就跳出循环。

---

同样的，如果我们在新窗口 操作结束后， 还要回到原来的窗口，该怎么办？

我们可以仍然使用上面的方法，依次切入窗口，然后根据 标题栏 之类的属性值判断。

还有更省事的方法。

因为我们一开始就在 原来的窗口里面，我们知道 进入新窗口操作完后，还要回来，可以事先 保存该老窗口的 句柄，使用如下方法

```

# mainWindow变量保存当前窗口的句柄
mainWindow = wd.current_window_handle

```

切换到新窗口操作完后，就可以直接像下面这样，将driver对应的对象返回到原来的窗口

```

#通过前面保存的老窗口的句柄，自己切换到老窗口
wd.switch_to.window(mainWindow)

```

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 课后练习

打开前面练习下载的 白月SMS系统的测试用例文档，白月SMS系统的 `安装步骤` 可以参考 `课程1的课后练习`

完成用例 `UI-0106` 的自动化

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

### 补充练习

实战班学员请联系老师获取补充练习题

---

<!-- Source: https://www.byhy.net/auto/selenium/skills_1/ -->

## 选择框

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

[请点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/test2.html)

并且按F12，观察HTML的内容

常见的选择框包括： radio框、checkbox框、select框

### radio框

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=18)

radio框选择选项，直接用WebElement的click方法，模拟用户点击就可以了。

比如, 我们要在下面的html中：

- 先打印当前选中的老师名字

- 再选择 小雷老师

```

<div id="s_radio">
  <input type="radio" name="teacher" value="小江老师">小江老师<br>
  <input type="radio" name="teacher" value="小雷老师">小雷老师<br>
  <input type="radio" name="teacher" value="小凯老师" checked="checked">小凯老师
</div>

```

对应的代码如下

```

# 获取当前选中的元素
element = wd.find_element(By.CSS_SELECTOR, 
  '#s_radio input[name="teacher"]:checked')
print('当前选中的是: ' + element.get_attribute('value'))

# 点选 小雷老师
wd.find_element(By.CSS_SELECTOR, 
  '#s_radio input[value="小雷老师"]').click()


```

其中 `#s_radio input[name="teacher"]:checked` 里面的 `:checked` 是CSS伪类选择

表示选择 `checked` 状态的元素，对 `radio` 和 `checkbox` 类型的input有效

### checkbox框

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=19)

对checkbox进行选择，也是直接用 WebElement 的 click 方法，模拟用户点击选择。

需要注意的是，要选中checkbox的一个选项，必须 `先获取当前该复选框的状态` ，如果该选项已经勾选了，就不能再点击。否则反而会取消选择。

比如, 我们要在下面的html中：选中 小雷老师

```

<div id="s_checkbox">
  <input type="checkbox" name="teachers1" value="小江老师">小江老师<br>
  <input type="checkbox" name="teachers1" value="小雷老师">小雷老师<br>
  <input type="checkbox" name="teachers1" value="小凯老师" checked="checked">小凯老师
</div>

```

我们的思路可以是这样：

- 先把 已经选中的选项全部点击一下，确保都是未选状态

- 再点击 小雷老师

示例代码

```

# 先把 已经选中的选项全部点击一下
elements = wd.find_elements(By.CSS_SELECTOR, 
  '#s_checkbox input[name="teachers1"]:checked')

for element in elements:
    element.click()

# 再点击 小雷老师
wd.find_element(By.CSS_SELECTOR, 
  "#s_checkbox input[value='小雷老师']").click()

```

### select框

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=20)

radio框及checkbox框都是input元素，只是里面的type不同而已。

select框 则是一个新的select标签，大家可以对照浏览器网页内容查看一下

对于Select 选择框， Selenium 专门提供了一个 `Select类` 进行操作，可以这样导入

```

from selenium.webdriver.support.select import Select

```

这个类实例化时传入 Select元素对应的 WebElement 对象，比如

```

select = Select(wd.find_element(By.ID, 'ss_single'))

```

Select类 提供了如下常用的 属性 和 方法

- all\_selected\_options

返回所有 `当前选中的option元素` 对应的 WebElement 对象

比如

```

for ele in select.all_selected_options:
    print(ele.text)

```

- select\_by\_value

根据选项的 `value属性值` ，选择元素。

比如，下面的HTML，

```

<option value="foo">Bar</option>

```

就可以根据 foo 这个值选择该选项，

```

select.select_by_value('foo')

```

- select\_by\_index

根据选项的 `次序` 选择元素

现在Selenium 4 是从 `0` 开始, 第一个选项 index 为 `0`

`select_by_index(0)` ，选择的是 第 `1` 个选项，

`select_by_index(1)` ，选择的是 第 `2` 个选项， 依此类推

以前，老版本的 Seleium，是从 `1` 开始

- select\_by\_visible\_text

根据选项的 `可见文本` ，选择元素。

比如，下面的HTML，

```

<option value="foo">Bar</option>

```

就可以根据 Bar 这个内容，选择该选项

```

select.select_by_visible_text('Bar')

```

- deselect\_by\_value

根据选项的value属性值， `去除` 选中元素

- deselect\_by\_index

根据选项的次序，`去除` 选中元素

- deselect\_by\_visible\_text

根据选项的可见文本，`去除` 选中元素

- deselect\_all

`去除` 选中所有元素

#### Select单选框

对于 select单选框，操作比较简单：

不管原来选的是什么，直接用Select方法选择即可。

例如，选择示例里面的小雷老师，示例代码如下

```

# 导入Select类
from selenium.webdriver.support.select import Select

# 创建Select对象
select = Select(wd.find_element(By.ID, "ss_single"))

# 通过 Select 对象选中小雷老师
select.select_by_visible_text("小雷老师")

```

#### Select多选框

对于select多选框，要选中某几个选项，要注意去掉原来已经选中的选项。

例如，我们选择示例多选框中的 小雷老师 和 小凯老师

可以用select类 的deselect\_all方法，清除所有 已经选中 的选项。

然后再通过 select\_by\_visible\_text方法 选择 小雷老师 和 小凯老师。

示例代码如下：

```

# 导入Select类
from selenium.webdriver.support.select import Select

# 创建Select对象
select = Select(wd.find_element(By.ID, "ss_multi"))

# 清除所有 已经选中 的选项
select.deselect_all()

# 选择小雷老师 和 小凯老师
select.select_by_visible_text("小雷老师")
select.select_by_visible_text("小凯老师")

```

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 课后练习

打开前面练习下载的 白月SMS系统的测试用例文档，白月SMS系统的 `安装步骤` 可以参考 `课程1的课后练习`

完成用例 `UI-0107` 的自动化

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

### 补充练习

实战班学员请联系老师获取补充练习题

---

<!-- Source: https://www.byhy.net/auto/selenium/skills_2/ -->

## 实战技巧

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 操作元素

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=21)

之前我们对web元素做的操作主要是：**选择元素**，然后 **点击元素** 或者 **输入** 字符串。

还有没有其他的操作了呢？

有。

比如：比如 鼠标右键点击、双击、移动鼠标到某个元素、鼠标拖拽等。

这些操作，可以通过 Selenium 提供的 `ActionChains` 类来实现。

ActionChains 类 里面提供了 一些特殊的动作的模拟，我们可以通过 ActionChains 类的代码查看到，如下所示

![image](https://www.byhy.net/cdn2/imgs/dt/25/0722-123828.png)

我们以鼠标 **光标悬停** 到某个元素，和 **拖放** 为例。

[点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/sample4.html)：

可以把鼠标放在导航栏最右边的 `更多` 上，就会弹出更多的导航项目。

下方正文区域，可以拖动左边实战班课程 放到 右边的选中区域。

示例代码如下：

```

from selenium import webdriver
from selenium.webdriver.common.by import By
import time

wd = webdriver.Chrome()
wd.implicitly_wait(5)

wd.get('https://www.byhy.net/cdn2/files/selenium/sample4.html')


from selenium.webdriver.common.action_chains import ActionChains
ac = ActionChains(wd)

time.sleep(3)

# 光标悬停 到元素上
ac.move_to_element(
    wd.find_element(By.CSS_SELECTOR, '.navbar-nav > li.dropdown')
).perform()

time.sleep(3)

# 拖放元素
for i in range(1,6):
    ac.drag_and_drop(
        wd.find_element(By.ID, f'course-{i}'),
        wd.find_element(By.ID,'selected-courses')
    ).perform()

    time.sleep(0.5)

input('\n\n按回车退出')

```

### 直接执行javascript

我们可以直接让浏览器运行一段javascript代码，并且得到返回值，如下

```

# 直接执行 javascript，里面可以直接用return返回我们需要的数据
nextPageButtonDisabled = driver.execute_script(
    '''
    ele = document.querySelector('.soupager > button:last-of-type');
    return ele.getAttribute('disabled')
    ''')

# 返回的数据转化为Python中的数据对象进行后续处理
if nextPageButtonDisabled == 'disabled': # 是最后一页
    return True
else: # 不是最后一页
    return False

```

有时，自动化的网页内容很长，或者很宽，超过一屏显示，

如果我们要点击的元素不在窗口可见区内，新版本的selenium协议， 浏览器发现要操作（比如点击操作）的元素，不在可见区内，往往会操作失败，

出现类似下面的提示

```

element click intercepted: Element <span>这里是元素html</span> 
is not clickable at point (119, 10). 
Other element would receive the click: <div>...</div>

```

这时，可以调用 `execute_script` 直接执行js代码，让该元素出现在窗口可见区正中

```

driver.execute_script("arguments[0].scrollIntoView({block:'center',inline:'center'})", job) 

```

其中 `arguments[0]` 就指代了后面的第一个参数 `job` 对应的js对象，

js对象的 `scrollIntoView` 方法，就是让元素滚动到可见部分

`block:'center'` 指定垂直方向居中

`inline:'center'` 指定水平方向居中

### 冻结界面

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=22)

有些网站上面的元素， 我们鼠标放在上面，会动态弹出一些内容。

比如，百度首页的右上角，有个 **更多产品** 选项，如下图所示

如果我们把鼠标放在上边，就会弹出 下面的 糯米、音乐、图片 等图标。

如果我们要用 selenium 自动化 点击 糯米图标，就需要 F12 查看这个元素的特征。

但是 当我们的鼠标 从 糯米图标 移开， 这个 栏目就整个消失了， 就没法 查看 其对应的 HTML。

怎么办？

可以如下图所示：

在 开发者工具栏 console 里面执行如下js代码

```

setTimeout(function(){debugger}, 5000)

```

这句代码什么意思呢？

表示在 5000毫秒后，执行 debugger 命令

执行该命令会 浏览器会进入debug状态。 debug状态有个特性， 界面被冻住， 不管我们怎么点击界面都不会触发事件。

所以，我们可以在输入上面代码并回车 执行后， 立即 鼠标放在界面 右上角 更多产品处。

这时候，就会弹出 下面的 糯米、音乐、图片 等图标。

然后，我们仔细等待 5秒 到了以后， 界面就会因为执行了 debugger 命令而被冻住。

然后，我们就可以点击 开发者工具栏的 查看箭头， 再去 点击 糯米图标 ，查看其属性了。

### 弹出对话框

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=23)

有的时候，我们经常会在操作界面的时候，出现一些弹出的对话框。

[请点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/test4.html)

分别点击界面的3个按钮，你可以发现：

弹出的对话框有三种类型，分别是 Alert（警告信息）、confirm（确认信息）和prompt（提示输入）

#### Alert

Alert 弹出框，目的就是显示通知信息，只需用户看完信息后，点击 OK（确定） 就可以了。

那么，自动化的时候，代码怎么模拟用户点击 OK 按钮呢？

selenium提供如下方法进行操作

```

driver.switch_to.alert.accept()

```

注意：如果我们不去点击它，页面的其它元素是不能操作的。

如果程序要获取弹出对话框中的信息内容， 可以通过 如下代码

```

driver.switch_to.alert.text

```

示例代码如下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.implicitly_wait(5)
driver.get('https://www.byhy.net/cdn2/files/selenium/test4.html')


# --- alert ---
driver.find_element(By.ID, 'b1').click()

# 打印 弹出框 提示信息
print(driver.switch_to.alert.text) 

# 点击 OK 按钮
driver.switch_to.alert.accept()

```

#### Confirm

Confirm弹出框，主要是让用户确认是否要进行某个操作。

比如：当管理员在网站上选择删除某个账号时，就可能会弹出 Confirm弹出框， 要求确认是否确定要删除。

Confirm弹出框 有两个选择供用户选择，分别是 OK 和 Cancel， 分别代表 确定 和 取消 操作。

那么，自动化的时候，代码怎么模拟用户点击 OK 或者 Cancel 按钮呢？

selenium提供如下方法进行操作

如果我们想点击 OK 按钮， 还是用刚才的 accept方法，如下

```

driver.switch_to.alert.accept()

```

如果我们想点击 Cancel 按钮， 可以用 dismiss方法，如下

```

driver.switch_to.alert.dismiss()

```

示例代码如下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.implicitly_wait(5)

driver.get('https://www.byhy.net/cdn2/files/selenium/test4.html')

# --- confirm ---
driver.find_element(By.ID, 'b2').click()

# 打印 弹出框 提示信息
print(driver.switch_to.alert.text)

# 点击 OK 按钮 
driver.switch_to.alert.accept()

driver.find_element(By.ID, 'b2').click()

# 点击 取消 按钮
driver.switch_to.alert.dismiss()

```

#### Prompt

出现 Prompt 弹出框 是需要用户输入一些信息，提交上去。

比如：当管理员在网站上选择给某个账号延期时，就可能会弹出 Prompt 弹出框， 要求输入延期多长时间。

可以调用如下方法

```

driver.switch_to.alert.send_keys()

```

示例代码如下

```

from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.implicitly_wait(5)
driver.get('https://www.byhy.net/cdn2/files/selenium/test4.html')


# --- prompt ---
driver.find_element(By.ID, 'b3').click()

# 获取 alert 对象
alert = driver.switch_to.alert

# 打印 弹出框 提示信息
print(alert.text)

# 输入信息，并且点击 OK 按钮 提交
alert.send_keys('web自动化 - selenium')
alert.accept()

# 点击 Cancel 按钮 取消
driver.find_element(By.ID, 'b3').click()
alert = driver.switch_to.alert
alert.dismiss()

```

有些弹窗并非浏览器的alert 窗口，而是**html元素**，这种对话框，只需要通过之前介绍的选择器选中并进行相应的操作就可以了。

### 其他技巧

下面是一些其他的 Selenium 自动化技巧

#### 窗口大小

有时间我们需要获取窗口的属性和相应的信息，并对窗口进行控制

- 获取窗口大小

```

driver.get_window_size()

```

- 改变窗口大小

```

driver.set_window_size(x, y)

```

#### 获取当前窗口标题

浏览网页的时候，我们的窗口标题是不断变化的，可以使用WebDriver的title属性来获取当前窗口的标题栏字符串。

```

driver.title

```

#### 获取当前窗口URL地址

```

driver.current_url

```

例如，访问网易，并获取当前窗口的标题和URL

```

from selenium import  webdriver

driver = webdriver.Chrome()
driver.implicitly_wait(5)

# 打开网站
driver.get('https://www.163.com')

# 获取网站标题栏文本
print(driver.title) 

# 获取网站地址栏文本
print(driver.current_url) 

```

#### 截屏

有的时候，我们需要把浏览器屏幕内容保存为图片文件。

比如，做自动化测试时，一个测试用例检查点发现错误，我们可以截屏为文件，以便测试结束时进行人工核查。

可以使用 WebDriver 的 get\_screenshot\_as\_file方法来截屏并保存为图片。

```

from selenium import  webdriver

driver = webdriver.Chrome()
driver.implicitly_wait(5)

# 打开网站
driver.get('https://www.baidu.com/')

# 截屏保存为图片文件
driver.get_screenshot_as_file('1.png')

```

#### 手机模式

我们可以通过 `desired_capabilities` 参数，指定以手机模式打开chrome浏览器

参考代码，如下

```

from selenium import webdriver

mobile_emulation = { "deviceName": "iPhone 14 Pro Max" }

chrome_options = webdriver.ChromeOptions()

chrome_options.add_experimental_option("mobileEmulation", mobile_emulation)

driver = webdriver.Chrome(options=chrome_options)

driver.get('http://www.baidu.com')

input()
driver.quit()

```

#### 上传文件

有时候，网站操作需要上传文件。

比如，著名的在线图片压缩网站： [https://tinypng.com/](https://tinypng.com/)

通常，网站页面上传文件的功能，是通过 `type` 属性 为 `file` 的 HTML `input` 元素实现的。

如下所示：

```

<input type="file" multiple="multiple">

```

使用selenium自动化上传文件，我们只需要定位到该input元素，然后通过 send\_keys 方法传入要上传的文件路径即可。

如下所示：

```

# 先定位到上传文件的 input 元素
ele = wd.find_element(By.CSS_SELECTOR, 'input[type=file]')

# 再调用 WebElement 对象的 send_keys 方法
ele.send_keys(r'h:\g02.png')

```

如果需要上传多个文件，可以多次调用send\_keys，如下

```

ele = wd.find_element(By.CSS_SELECTOR,  'input[type=file]')
ele.send_keys(r'h:\g01.png')
ele.send_keys(r'h:\g02.png')

```

但是，有的网页上传，是没有 file 类型 的 input 元素的。

如果是Windows上的自动化，可以采用 Windows 平台专用的方法：

执行

```

pip install pypiwin32

```

确保 pywin32 已经安装，然后参考如下示例代码

```

# 找到点击上传的元素，点击
driver.find_element(By.CSS_SELECTOR, '.dropzone').click()

sleep(2) # 等待上传选择文件对话框打开

# 直接发送键盘消息给 当前应用程序，
# 前提是浏览器必须是当前应用
import win32com.client
shell = win32com.client.Dispatch("WScript.Shell")

# 输入文件路径，最后的'\n'，表示回车确定，也可能时 '\r' 或者 '\r\n'
shell.Sendkeys(r"h:\a2.png" + '\n')
sleep(1)

```

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### 课后练习

打开前面练习下载的 白月SMS系统的测试用例文档，白月SMS系统的 `安装步骤` 可以参考 `课程1的课后练习`

完成用例 `UI-0108` 的自动化

`实战班学员` ，请联系老师获取参考答案和视频讲解

`游客` 也可以 分享课程 领取练习视频讲解，[点击这里查看](https://www.byhy.net/adv/bonus/selenium/)

### 补充练习

实战班学员请联系老师获取补充练习题

---

<!-- Source: https://www.byhy.net/auto/selenium/xpath_1/ -->

## Xpath选择器

您需要高效学习，找工作？

点击这里 白月黑羽实战班

点击查看学员就业情况

### Xpath语法简介

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=24)

前面我们学习了CSS 选择元素。

大家可以发现非常灵活、强大。

还有一种 灵活、强大 的选择元素的方式，就是使用 `Xpath` 表达式。

XPath (XML Path Language) 是由国际标准化组织W3C指定的，用来在 XML 和 HTML 文档中选择节点的语言。

目前主流浏览器 (chrome、firefox，edge，safari) 都支持XPath语法，xpath有多个版本，目前浏览器支持的是 xpath 1的语法。

既然已经有了CSS，为什么还要学习 Xpath呢？ 因为

- 有些场景 用 css 选择web 元素 很麻烦，而xpath 却比较方便。

- 另外 Xpath 还有其他领域会使用到，比如 爬虫框架 Scrapy， 手机App框架 Appium。

[请点击打开这个网址](https://www.byhy.net/cdn2/files/selenium/test1.html)

按F12打开调试窗口，点击 Elements标签。

要验证 Xpath 语法是否能成功选择元素，也可以像 验证 CSS 语法那样，按组合键 Ctrl + F ，就会出现 搜索框

xpath 语法中，整个HTML文档根节点用'/'表示，如果我们想选择的是根节点下面的html节点，则可以在搜索框输入

```

/html

```

如果输入下面的表达式

```

/html/body/div

```

这个表达式表示选择html下面的body下面的div元素。

注意 `/` 有点像 CSS中的 `>` , 表示直接子节点关系。

#### 绝对路径选择

从根节点开始的，到某个节点，每层都依次写下来，每层之间用 `/` 分隔的表达式，就是某元素的 `绝对路径`

上面的xpath表达式 `/html/body/div` ，就是一个绝对路径的xpath表达式， 类似 css表达式 `html>body>div`

自动化程序要使用Xpath来选择web元素，使用 `By.XPATH` ，像这样：

```

elements = driver.find_elements(By.XPATH, "/html/body/div/select")

```

#### 相对路径选择

有的时候，我们需要选择网页中某个元素， `不管它在什么位置` 。

比如，选择示例页面的所有标签名为 `div` 的元素，如果使用css表达式，直接写一个 `div` 就行了。

那xpath怎么实现同样的功能呢？ xpath需要前面加 `//` , 表示从当前节点往下寻找所有的后代元素,不管它在什么位置。

所以xpath表达式，应该这样写： `//div`

'//' 符号也可以继续加在后面,比如，要选择 所有的 div 元素里面的 所有的 p 元素 ，不管div 在什么位置，也不管p元素在div下面的什么位置，则可以这样写 `//div//p`

对应的自动化程序如下

```

elements = driver.find_elements(By.XPATH, "//div//p")

```

如果使用CSS选择器，对应代码如下

```

elements = driver.find_elements(By.CSS_SELECTOR,"div p")

```

如果，要选择 所有的 div 元素里面的 直接子节点 p ， xpath，就应该这样写了 `//div/p`

如果使用CSS选择器，则为 `div > p`

#### 通配符

如果要选择所有div节点的所有直接子节点，可以使用表达式 `//div/*`

`*` 是一个通配符，对应任意节点名的元素，类似 CSS选择器 `div > *`

代码如下：

```

elements = driver.find_elements(By.XPATH, "//div/*")
for element in elements:
    print(element.get_attribute('outerHTML'))

```

### 根据属性选择

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=25)

Xpath 可以根据属性来选择元素。

根据属性来选择元素 是通过 这种格式来的 `[@属性名='属性值']`

注意：

- 属性名注意前面有个@

- 属性值一定要用引号， 可以是单引号，也可以是双引号

#### 根据id属性选择

选择 id 为 west 的元素，可以这样 `//*[@id='west']`

#### 根据class属性选择

选择所有 select 元素中 class为 single\_choice 的元素，可以这样 `//select[@class='single_choice']`

如果一个元素class 有多个，比如

```

<p id="beijing" class='capital huge-city'>
    北京    
</p>

```

如果要选 它， 对应的 xpath 就应该是 `//p[@class="capital huge-city"]`

不能只写一个属性，像这样 `//p[@class="capital"]` 则不行

#### 根据其他属性

同样的道理，我们也可以利用其它的属性选择

比如选择 具有multiple属性的所有页面元素 ，可以这样 `//*[@multiple]`

#### 属性值包含字符串

要选择 style属性值 包含 color 字符串的 页面元素 ，可以这样 `//*[contains(@style,'color')]`

要选择 style属性值 以 color 字符串 `开头` 的 页面元素 ，可以这样 `//*[starts-with(@style,'color')]`

要选择 style属性值 以 某个 字符串 结尾 的 页面元素 ，大家可以推测是 `//*[ends-with(@style,'color')]`， 但是，很遗憾，这是xpath 2.0 的语法 ，目前浏览器都不支持

### 按次序选择

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=26)

前面学过css表达式可以根据元素在父节点中的次序选择， 非常实用。

xpath也可以根据次序选择元素。 语法比css更简洁，直接在方括号中使用数字表示次序

比如

#### 某类型 第几个 子元素

比如

要选择 p类型第2个的子元素，就是

```

//p[2]

```

注意，选择的是 `p类型第2个的子元素` ， 不是 `第2个子元素，并且是p类型` 。

注意体会区别

再比如，要选取父元素为div 中的 p类型 第2个 子元素

```

//div/p[2]

```

#### 第几个子元素

也可以选择第2个子元素，不管是什么类型，采用通配符

比如 选择父元素为div的第2个子元素，不管是什么类型

```

//div/*[2]

```

#### 某类型 倒数第几个 子元素

当然也可以选取倒数第几个子元素

比如：

- 选取p类型倒数第1个子元素

```

//p[last()]

```

- 选取p类型倒数第2个子元素

```

//p[last()-1]

```

- 选择父元素为div中p类型倒数第3个子元素

```

//div/p[last()-2]

```

#### 范围选择

xpath还可以选择子元素的次序范围。

比如，

- 选取option类型第1到2个子元素

```

//option[position()<=2]

```

或者

```

//option[position()<3]

```

- 选择class属性为multi\_choice的前3个子元素

```

//*[@class='multi_choice']/*[position()<=3]

```

- 选择class属性为multi\_choice的后3个子元素

```

//*[@class='multi_choice']/*[position()>=last()-2]

```

为什么不是 `last()-3` 呢？ 因为

`last()` 本身代表最后一个元素

`last()-1` 本身代表倒数第2个元素

`last()-2` 本身代表倒数第3个元素

### 组选择、父节点、兄弟节点

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=27)

#### 组选择

css有组选择，可以同时使用多个表达式，多个表达式选择的结果都是要选择的元素

css 组选择，表达式之间用 **逗号** 隔开

xpath也有组选择， 是用 **竖线** 隔开多个表达式

比如，要选所有的option元素 和所有的 h4 元素，可以使用

```

//option | //h4

```

等同于CSS选择器

```

option , h4

```

再比如，要选所有的 class 为 single\_choice 和 class 为 multi\_choice 的元素，可以使用

```

 //*[@class='single_choice'] | //*[@class='multi_choice']

```

等同于CSS选择器

```

.single_choice , .multi_choice

```

#### 选择父节点

xpath可以选择父节点， 这是css做不到的。

某个元素的父节点用 `/..` 表示

比如，要选择 id 为 china 的节点的父节点，可以这样写 `//*[@id='china']/..` 。

当某个元素没有特征可以直接选择，但是它有子节点有特征， 就可以采用这种方法，先选择子节点，再指定父节点。

还可以继续找上层父节点，比如 `//*[@id='china']/../../..`

#### 兄弟节点选择

前面学过 css选择器，要选择某个节点的后续兄弟节点，用 **波浪线**

xpath也可以选择 后续 兄弟节点，用这样的语法 `following-sibling::`

比如，要选择 class 为 single\_choice 的元素的所有后续兄弟节点 `//*[@class='single_choice']/following-sibling::*`

等同于CSS选择器 `.single_choice ~ *`

如果，要选择后续节点中的div节点， 就应该这样写 `//*[@class='single_choice']/following-sibling::div`

xpath还可以选择 `前面的` 兄弟节点，用这样的语法 `preceding-sibling::`

比如，要选择 class 为 single\_choice 的元素的 `所有` 前面的兄弟节点，这样写

```

//*[@class='single_choice']/preceding-sibling::*

```

要选择 class 为 single\_choice 的元素的

前面最靠近的兄弟节点 , 这样写

```

//*[@class='single_choice']/preceding-sibling::*[1]

```

前面第2靠近的兄弟节点 , 这样写

```

//*[@class='single_choice']/preceding-sibling::*[2]

```

而 CSS选择器 目前还没有方法选择 `前面的` 兄弟节点

要了解更多Xpath选择语法，可以[点击这里，打开Xpath选择器参考手册](http://www.w3school.com.cn/xpath/index.asp)

### selenium 注意点

[点击这里，边看视频讲解，边学习以下内容](https://www.bilibili.com/video/BV14K8NzUEF3?p=28)

我们来看一个例子

我们的代码：

- 先选择示例网页中，id是china的元素

- 然后通过这个元素的WebElement对象，使用find\_elements\_by\_xpath，选择里面的p元素，

```


# 先寻找id是china的元素
china = wd.find_element(By.ID, 'china')

# 再选择该元素内部的p元素
elements = china.find_elements(By.XPATH, '//p')

# 打印结果
for element in elements:
    print('----------------')
    print(element.get_attribute('outerHTML'))

```

运行发现，打印的 不仅仅是 china内部的p元素， 而是所有的p元素。

要在某个元素内部使用xpath选择元素， 需要 `在xpath表达式最前面加个点` 。

像这样

```

elements = china.find_elements(By.XPATH, './/p')

```
