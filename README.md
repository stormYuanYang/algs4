# algs4
## 目的
《论语》说“学而不思则罔，思而不学则殆”，为了更好地学习算法知识，建立此项目——记录《algs4》的学习笔记。此项目主要包含：

+   《algs4》算法例子的完整实现；
+   《algs4》部分课后习题的代码实现；
+   一些心得体会。

## HOW TO USE？

如果你需要参考我的学习笔记，请继续向下看。

《algs4》提供的方法库algs4.jar已经包含在此项目中；注意不要对algs4.jar执行解压命令；将algs4.jar加入环境变量PATH中（如何操作请参考网络上的JAVA环境变量配置教程）。

《algs4》还提供了很多数据文件；因为数据文件过大超过了github的文件大小限制，所以项目中未包含数据文件，你可以到[algs4的配套网站](https://algs4.cs.princeton.edu/)去下载数据文件。

## 备注

我实现《algs4》的算法和习题，主要是用JAVA语言的基本语法知识，JAVA提供的一些高级语法不会涉及(可能会有少量的Lua脚本，比如myjava.lua)；另外编写这些代码的目的是学习算法，所以代码的健壮性是不能和生产环境代码相比的；比如申请内存失败、整数溢出等等异常情况，不考虑处理；毕竟主要目的只是学习算法。

在编写代码过程中，我比较喜欢大量使用JAVA提供的assert关键词（也就是断言），可以帮助我及时发现错误；但是JAVA虚拟机默认是不启用assert关键词的，如果你想要assert关键词生效，就需要在执行JAVA文件时，加上**-ea**参数，比如：

```bash
javac test.java && java -ea test
```

关于myjava.lua文件的说明。因为我目前的工作语言主要是Lua和C语言，开发工具主要是Vim；大量地输入命令行手挺累的（我比较懒啦:）；所以为编译并执行java文件编写了myjava.lua脚本；并在Vim的配置文件中用vimscript语言编写了自定义的函数function myjava()（此函数调用myjava.lua），然后由Vim调用function myjava()一键编译并执行单个java文件。

## TODO

后面考虑用python语言重写myjava.lua（不过暂时没必要(>‿◠)）。