-- 由命令行传入的参数保存在arg数组中
local filename  = arg[1]
local inputfile = arg[2]
local executeStr
-- 暂时只写了JAVA的编译命令和执行命令
-- lua中的转义符号是%而不是\
local first = string.find(filename, "%.java$")
if first then
    local outname = string.sub(filename, 1, first-1)
    if not outname then
        print("outname not find")
    else
        if inputfile then
            executeStr = string.format("javac %s && java -ea %s < %s ", filename, outname, inputfile)
        else
            executeStr = string.format("javac %s && java -ea %s ", filename, outname)
        end
    end
else
    print(string.format("I can't, filename:%s is illegal", filename))
end

if executeStr then
    os.execute(executeStr)
end
