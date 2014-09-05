
// 현재 날짜 구하기
var CUR_DATE = new Date();
var SEL_YEAR = CUR_DATE.getFullYear();
var SEL_MONTH = CUR_DATE.getMonth();

// 사용자 시작일 : 말일
var userStartDay = 0;
if (userStartDay == 0) {
	SEL_MONTH = SEL_MONTH + 1;
}

/////좌측 메뉴 숨기기/보이기
function showHideCalendar() {
    if ($("#left_calendar").is(":visible")) {
        $("#left_calendar").hide();
        $("#right_list").removeClass('col-md-6').addClass('col-md-9');
    } else {
        $("#left_calendar").show();
        $("#right_list").removeClass('col-md-9').addClass('col-md-6');
    }
}

// 출력용 날짜 만들기 (YYYYMMDD)
function makePrintDate(date) {
    var str = date.getFullYear() + ".";
    str += makeStrTwoLenght(date.getMonth() + 1) + ".";
    str += makeStrTwoLenght(date.getDate());
    return str;
}

function ODDate() {
    this.year = '';
    this.month = '';
    // 시작 날짜
    this.startDate = '';
    // 시작 요일
    this.startWeek = '';
    // 시작 일자
    this.startDay = '';
    // 종료 날짜
    this.endDate = '';
    // 종료 일자
    this.endDay = '';
    // 월의 마지막 일자
    this.lastDay = '';
}

// 시작 날짜와 시작 요일을 셋팅한다.
ODDate.prototype.setODDate = function (year, month, startDay) {
    this.year = year;
    this.month = month;
    this.startDate = new Date(year, month, startDay);
    this.startWeek = this.startDate.getDay();
    this.startDay = this.startDate.getDate();
    this.lastDay = new Date(this.startDate.getFullYear(), this.startDate.getMonth() + 1, 0).getDate();
    this.endDate = new Date(this.startDate.getFullYear(), this.startDate.getMonth(), this.startDate.getDate() - 1);
    this.endDay = this.endDate.getDate();
};

/////좌측 메뉴 달력 만들기
function makeMiniDiary(id) {

	var preYear = SEL_YEAR;
	var preMonth = SEL_MONTH - 1;
	if (preMonth < 1) {
        preYear = SEL_YEAR - 1;
        preMonth = 12;
    }

    var preMonthDate = new ODDate();
    var thisMonthDate = new ODDate();

    preMonthDate.setODDate(preYear, preMonth, userStartDay);
    thisMonthDate.setODDate(SEL_YEAR, SEL_MONTH, userStartDay);

    // 달력 년, 월, 요일 html 생성
    var dtmsg = "<tr height='40' class='border_bt'><td class='month_selector' onclick=\"moveLeftMonth('-')\"><span class='glyphicon glyphicon-chevron-left'/></td>";
    dtmsg += "<td colspan='5' align='center'><div class='month_title_font'>" + makePrintDate(preMonthDate.startDate) + " ~ " + makePrintDate(thisMonthDate.endDate) + "</div></td>";
    dtmsg += "<td class='month_selector' onclick=\"moveLeftMonth('+')\"><span class='glyphicon glyphicon-chevron-right'/></td></tr>";

    dtmsg += "<tr align='center' height='21' class='border_bt'>";
    dtmsg += makeWeekTd("일");
    dtmsg += makeWeekTd("월");
    dtmsg += makeWeekTd("화");
    dtmsg += makeWeekTd("수");
    dtmsg += makeWeekTd("목");
    dtmsg += makeWeekTd("금");
    dtmsg += makeWeekTd("토");
    dtmsg += "</tr>"

    // 달력의 시작일
    var year = preMonthDate.year;
    var month = preMonthDate.month;
    var day = preMonthDate.startDay;
    var cal_start_day = day - preMonthDate.startWeek;
    var td_count = calcDay(preMonthDate.startDate, thisMonthDate.endDate) + preMonthDate.startWeek;
    var dmsg = "";
    for (var td_idx = 0; td_idx < td_count; td_idx++) {
        // 달의 시작일이 일요일이 아니라면 1일까지 빈 공간을 만들어준다.
        if (td_idx < preMonthDate.startWeek) {
            if (td_idx == 0) dmsg += makeDayFirstTd(year, month, cal_start_day);
            else dmsg += makeDayTd(year, month, cal_start_day);
            cal_start_day++;
        } else {
            if (td_idx == 0) dmsg += makeDayFirstTd(year, month, day);
            else dmsg += makeDayTd(year, month, day);

            day++;
            if (day > preMonthDate.lastDay && month == preMonthDate.month) {
                day = 1;
                month = month + 1;
                if (month > 12) {
                    year = year + 1;
                    month = 1;
                }
            }

        }

        // 마지막날이 토요일이면 다음달 1주일을 더 보여주기 위해 tr을 추가한다.
        if ((td_idx <= td_count - 1) && (((td_idx + 1) % 7) == 0)) {
            dmsg += "</tr><tr>";
        }
    }


    // 마지막날이 토요일이 아닐 경우, tr의 남은 td를 채워주고 다음달을 넣는다.
    var next_month_td = 7;
    if ((td_count % 7) > 0) {
        next_month_td += (7 - (td_count % 7))
    }
    for (td_idx = 0; td_idx < next_month_td; td_idx++) {
        if ((7 - (td_count % 7) > 0) && ((td_count % 7) >= 0)) {
            dmsg += makeDayTd(year, month, day);
        }

        // 마지막날이 토요일이면 다음달 1주일을 더 보여주기 위해 tr을 추가한다.
        if (td_idx + 1 == (7 - (td_count % 7))) {
            dmsg += "</tr><tr>";
        }

        day++;

        if (day > thisMonthDate.lastDay) {
            day = 1;
            month = month + 1;
            if (month > 12) {
                year = year + 1;
                month = 1;
            }
        }
    }

    // 생성한 달력 붙여넣기
    $("#leftdiary").html("<table width='100%' border='0' cellspacing='0' cellpadding='0'>" + dtmsg + "<tr>" + dmsg + "</tr></table>");

    // 오늘 날짜 표시
    var str_now = CUR_DATE.getFullYear() + makeStrTwoLenght(CUR_DATE.getMonth() + 1) + makeStrTwoLenght(CUR_DATE.getDate());
    $("#" + str_now + " .td_calendar_day").addClass('today');
    $("#" + str_now).addClass('select_day');
    


    // 달력 오른쪽 라인 그리기
    $("#leftdiary td:nth-child(7)").css('border-right', 'solid 1px #cccccc');

    // 일요일/공휴일 날짜
    $("#leftdiary tr:gt(1) td:nth-child(1)").addClass('srfont');

    // 이전달/다음달 날짜 회색 처리
    var thisStartMonth = preMonthDate.year + makeStrTwoLenght(preMonthDate.month) + makeStrTwoLenght(preMonthDate.startDay);
    var thisEndMonth = thisMonthDate.year + makeStrTwoLenght(thisMonthDate.month) + makeStrTwoLenght(thisMonthDate.endDay);
    $("#leftdiary tr:gt(1) td").each(function () {
        $this = $(this).find('div').attr('id');


        if (!((thisEndMonth >= $this) && ($this >= thisStartMonth))) {            
            $(this).find('div').addClass("alpha50");
        }
        $(this).css('border', 'solid 1px #cccccc');
    });

    if (id) {
    	$("#"+id).addClass('select_day');
    }

    // 선택 날짜 표시
    $("#leftdiary table tr td").click(function() {
    	var $this = $(this);

    	$(".select_day").removeClass('select_day');
    	$this.addClass('select_day');

    	var id = $this.find('div').attr('id');

    	if ($this.find('.alpha50').length > 0) {
	    	if (thisEndMonth >= id) {
	    	 	moveLeftMonth('-', id);
	    	} else if (id >= thisStartMonth) {
	    		moveLeftMonth('+', id);
	    	}
	    }    

    	//console.log($this.find('div')[0].id);
    	//location.href = "#"+$this.find('div')[0].id;

    });

}

// 날짜 카운트
function calcDay(startDate, endDate) {
    var gap = startDate.getTime() - endDate.getTime()
    gap = Math.floor(gap / (1000 * 60 * 60 * 24)) * -1;
    return gap + 1;
}

/////좌측 메뉴 달력 월 이동
function moveLeftMonth(v, id) {
    // 다음달
    if (v == "+") {
        SEL_MONTH++;
        if (SEL_MONTH > 12) {
            SEL_YEAR++;
            SEL_MONTH = 1;
        }
    }
    // 이전달
    else {
        SEL_MONTH--;
        if (SEL_MONTH < 1) {
            SEL_YEAR--;
            SEL_MONTH = 12;
        }
    }

    makeMiniDiary(id);
}

// 요일 TD 만들기
function makeWeekTd(val) {
    return "<td width='14%' class='border_lt'>" + val + "</td>"
}

// 날짜 TD 만들기
function makeDayTd(yyyy, mm, dd) {
    var id = yyyy + makeStrTwoLenght(mm) + makeStrTwoLenght(dd);
    var day = dd;
    if (dd == 1) {
        day = mm + "/" + day;
    }
    return makeCaleandar(id, day, holidayCheck(yyyy, mm, dd));
}

// 전월 첫번째 날짜TD에 월 표시
function makeDayFirstTd(yyyy, mm, dd) {
    var id = yyyy + makeStrTwoLenght(mm) + makeStrTwoLenght(dd);
    var day = mm + "/" + dd;
    return makeCaleandar(id, day, holidayCheck(yyyy, mm, dd));
}

function makeCaleandar(id, day, memorialDay) {
	var strClass = 'td_calendar';
	if (memorialDay) strClass += ' srfont';

    return "<td><div class='"+strClass+"' id='" + id + "'><div class='td_calendar_day'>" + day + "</div><div id='out' class='td_money_out'></div><div id='save' class='td_money_save'></div><div id='in' class='td_money_in'></div></div></td>";
}

// 두자리 월 만들기
function makeStrTwoLenght(val) {
    var str_val = val + "";
    if (str_val.length == 1) {
        str_val = "0" + str_val;
    }
    return str_val;
}

// RGB를 HEX로 변환하는 함수
function rgb2hex(rgb) {
    if (rgb.search("rgb") == -1) {
        return rgb;
    } else {
        rgb = rgb.match(/^rgba?\((\d+),\s*(\d+),\s*(\d+)(?:,\s*(\d+))?\)$/);

        function hex(x) {
            return ("0" + parseInt(x).toString(16)).slice(-2);
        }
        return "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
    }
}


//////////////////////////////////////////////////////////////////////////

//매년 반복되는 기념일
function memorialDay(name, month, day, solarLunar, holiday, type) {
    this.name = name;
    this.month = month;
    this.day = day;
    this.solarLunar = solarLunar;
    this.holiday = holiday; /* true : 빨간날 false : 안빨간날 */
    this.type = type; /* true : real time setting */
    this.techneer = true;
}
    
var memorialDays = Array(
    new memorialDay("신정", 1, 1, 1, true),
    new memorialDay("", 12, 0, 2, true, true), /* 실시간으로 정해짐 */
    new memorialDay("설날", 1, 1, 2, true),
    new memorialDay("", 1, 2, 2, true),
    new memorialDay("3·1절", 3, 1, 1, true),
    new memorialDay("석가탄신일", 4, 8, 2, true),
    new memorialDay("어린이날", 5, 5, 1, true),
    new memorialDay("현충일", 6, 6, 1, true),
    new memorialDay("광복절", 8, 15, 1, true),
    new memorialDay("", 8, 14, 2, true),
    new memorialDay("추석", 8, 15, 2, true),
    new memorialDay("", 8, 16, 2, true),
    new memorialDay("개천절", 10, 3, 1, true),
    new memorialDay("성탄절", 12, 25, 1, true),
    new memorialDay("한글날", 10, 9, 1, true)
);

function holidayCheck(year, month, day) {

    /* set the day before 설날 */
    if (lunarMonthTable[year - 1 - 1799][11] == 1)
        memorialDays[1].day = 29;
    else if (lunarMonthTable[year - 1 - 1799][11] == 2)
        memorialDays[1].day = 30;

	var solarDate = new myDate(year, month, day);
    var lunarDate = lunarCalc(year, month, day, 1);

    var memorial = memorialDayCheck(solarDate, lunarDate);

    var memorialDay = false;
    if (memorial && memorial.holiday == true)
        memorialDay = true;

    return memorialDay;
}

function memorialDayCheck(solarDate, lunarDate) {

    var i;
    var memorial;

    for (i = 0; i < memorialDays.length; i++) {
        if (memorialDays[i].month == solarDate.month &&
            memorialDays[i].day == solarDate.day &&
            memorialDays[i].solarLunar == 1)
            return memorialDays[i];

        //윤달의 공휴일 처리에 대한 예외처리 
        if (lunarDate.leapMonth && lunarDate.month == 4 && lunarDate.day == 8) {
            return null;
        }
        if (lunarDate.leapMonth && lunarDate.month == 8 && lunarDate.day > 13 && lunarDate.day < 17) {
            return null;
        }
        if (memorialDays[i].month == lunarDate.month &&
            memorialDays[i].day == lunarDate.day &&
            memorialDays[i].solarLunar == 2 &&
            !memorialDays[i].leapMonth) 
            return memorialDays[i];
    }
    return null;
}
