#!/bin/bash
url="http://www.imooc.com/learn/"
stateCode=""
mkdir html
htmlDic="`pwd`/html"
from=1
to=1000
urlCount=`expr $to - $from + 1`
beginTime=`date +%Y-%m-%d' '%H:%M:%S`
rightUrlCount=0
wrongUrlCount=0
start=$(date +%s)
for (( i = $from; i <= $to; i++ )); do
	stateCode=`curl -I $url$i|grep 'HTTP'|cut -d' ' -f2`
	if [ $stateCode = "200" ]; then
		((rightUrlCount++))
		echo "url:$url$i	code:$stateCode"		
		curl $url$i>>"$htmlDic/course_$i.html"
		echo -e "url:$url$i,code:$stateCode\r\n">>"$htmlDic/html.log"
	else
		((wrongUrlCount++))
		echo "get page failed!url:$url$i	code:$stateCode"
	fi
done
endTime=`date +%Y-%m-%d' '%H:%M:%S`
end=$(date +%s)
spendTime=$(( $end - $start ))
runSpeed=`echo "scale=2;$spendTime/$urlCount"|bc`
echo -e "---------------------------------------\r\n">>"$htmlDic/html.log"
echo -e "beginTime:$beginTime\r\n">>"$htmlDic/html.log"
echo -e "endTime:$endTime\r\n">>"$htmlDic/html.log"
echo -e "runTime:$spendTime(s)\r\n">>"$htmlDic/html.log"
echo -e "urlCount:$urlCount\r\n">>"$htmlDic/html.log"
echo -e "rightUrlCount:$rightUrlCount\r\n">>"$htmlDic/html.log"
echo -e "wrongUrlCount:$wrongUrlCount\r\n">>"$htmlDic/html.log"
echo -e "runSpeed:$runSpeed\r\n">>"$htmlDic/html.log"
echo -e "---------------------------------------\r\n">>"$htmlDic/html.log"
cat "$htmlDic/html.log"
