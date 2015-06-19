'use strict';

var EgunUtility = {};

EgunUtility.doPost = function (url, paramObj, callback) {
  $.post(url, paramObj, function (response) {
    if (EgunUtility.isSuccessResponse(response)) {
      if (EgunUtility.hasResponseData(response)) {
        callback(response.value);
      }
      else {
        if (callback != undefined && callback != null) {
          callback();
        }
      }
    }
    return EgunUtility.showfailMessage(response);
  });
};

/**
 * 반드시 'application/json' 타입으로 호출하는 POST 통신
 * 
 * @author <a href="mailto:dklee@gn-soft.co.kr">이동규</a>
 * @since 2015.03.12
 */
EgunUtility.doNativePost = function(url, paramObj, callback) {
  $.ajax({
    url : url,
    dataType : 'json',
    type : 'POST',
    contentType : 'application/json',
    data : JSON.stringify(paramObj),
    success : function(response) {
      if (EgunUtility.isSuccessResponse(response)) {
        if (EgunUtility.hasResponseData(response)) {
          callback(response.value);
        }
        else {
          if (callback != undefined && callback != null) {
            callback();
          }
        }
      }
      return EgunUtility.showfailMessage(response);
    }
  });
};
         
EgunUtility.doGet = function (url, paramObj, callback) {
  $.get(url, paramObj, function (response) {
    if (EgunUtility.isSuccessResponse(response)) {
      if (EgunUtility.hasResponseData(response)) {
        callback(response.value);
      }
      else {
        if (callback != undefined && callback != null) {
          callback();
        }
      }
    }
    return EgunUtility.showfailMessage(response);
  });
};

EgunUtility.doPut = function (url, paramObj, callback) {
  $.ajax({
    url : url,
    type : 'PUT',
    success: function(response) {
      if (EgunUtility.isSuccessResponse(response)) {
        if (EgunUtility.hasResponseData(response)) {
          callback(response.value);
        }
        else {
          if (callback != undefined && callback != null) {
            callback();
          }
        }
      }
      return EgunUtility.showfailMessage(response);
    }
  });
};

EgunUtility.doDelete = function (url, paramObj, callback) {
  $.ajax({
    url : url,
    type : 'DELETE',
    success: function(response) {
      if (EgunUtility.isSuccessResponse(response)) {
        if (EgunUtility.hasResponseData(response)) {
          callback(response.value);
        }
        else {
          if (callback != undefined && callback != null) {
            callback();
          }
        }
      }
      return EgunUtility.showfailMessage(response);
    }
  });
};
         
EgunUtility.isSuccessResponse = function (response) {
    return response.success === true;
};

EgunUtility.hasResponseData = function(response) {
    return response.value != undefined && response.value != null;
}
EgunUtility.goPage = function (nextPageUrl) {
    document.location.href = nextPageUrl;
};

EgunUtility.showfailMessage = function(response) {
  if (response.success === true) return;
  
  alert(response.errorMessage1);
}

//var EgunCar = {
//  var objectId = '';
//  var userEmailAddress = '';
//  var alias = '';
//  var modelName = '';
//  var automaker = '';
//  var makeYear = '';
//  var buyDate = '';
//  var carNumber = '';
//  var vin = '';
//  var memo = '';
//};
//

//var EgunCar = {};
//EgunCar.prototype.objectId = '';
//EgunCar.prototype.userEmailAddress = '';
//EgunCar.prototype.alias = '';
//EgunCar.prototype.modelName = '';
//EgunCar.prototype.automaker = '';
//EgunCar.prototype.makeYear = '';
//EgunCar.prototype.buyDate = '';
//EgunCar.prototype.carNumber = '';
//EgunCar.prototype.vin = '';
//EgunCar.prototype.memo = '';