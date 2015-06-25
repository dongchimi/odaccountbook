package org.dongchimi.odong.accountbook.web.resource;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.dongchimi.odong.accountbook.domain.AssetType;
import org.dongchimi.odong.accountbook.dto.AssetDto;
import org.dongchimi.odong.accountbook.service.AssetService;
import org.dongchimi.odong.accountbook.service.CategoryService;
import org.dongchimi.odong.accountbook.service.ODAccountBookLogService;
import org.dongchimi.odong.accountbook.web.util.ODException;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.dongchimi.odong.accountbook.web.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis/assets")
public class ODAssetResource {

    @Autowired
    private AssetService assetService;

    @Autowired
    private ODAccountBookLogService accountBookLogService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 자산 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getAssets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getAssets(HttpSession session) {

        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);

        if (currentAccountBookOid == null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("로그인하세요."));
        }

        return ODRequestResultBuilder.getSuccessRequestResult(assetService
                .findAssetDtos(currentAccountBookOid));
    }

    /**
     * 자산유형 조회
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/getAssetTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult getAssetTypes(HttpSession session) {
        return ODRequestResultBuilder.getSuccessRequestResult(AssetType.values());
    }

    /**
     * 자산 등록
     * 
     * @return
     */
    @RequestMapping(value = "/setAsset", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult setAsset(HttpSession session, @RequestParam String assetTypeCode,
            @RequestParam String name, @RequestParam int balance, @RequestParam String memo,
            @RequestParam(required = false) String oid) {

        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);

        if (currentAccountBookOid == null) {
            return ODRequestResultBuilder.getFailRequestResult(new ODException("로그인하세요."));
        }

        Asset asset = null;
        if (StringUtils.isEmpty(oid)) {
            // 등록
            asset = new Asset(AssetType.toAssetType(assetTypeCode), name, memo,
                    currentAccountBookOid);
        } else {
            // 수정
            AssetDto assetDto = assetService.getAssetDto(Long.parseLong(oid));

            assetDto.setAssetType(AssetType.toAssetType(assetTypeCode));
            assetDto.setName(name);
            assetDto.setMemo(memo);

            asset = assetDto.toAsset();
        }

        assetService.registerAsset(asset);

        // TODO 잔액이 0이 아닌 경우 가계부내역 등록하기
        // if (balance != 0) {
        // HowType howType = HowType.IN;
        // if (balance < 0) {
        // howType = HowType.OUT;
        // }
        //
        // ODAccountBookLog accountBookLog = new
        // ODAccountBookLog(currentAccountBookOid, howType,
        // DateUtil.getTodayForBaseFormat(), "잔액수정", balance,
        // currentUser.getOid());
        // accountBookLog.setRelatedAsset(registeredAsset);
        //
        // List<Category> categories = categoryService
        // .findGroupCategoriesByAccountBookOidAndHowType(currentAccountBookOid,
        // howType);
        // accountBookLog.setRelatedCategory(categories.get(categories.size() -
        // 1));
        //
        // accountBookLogService.registerAccountBookLog(accountBookLog);
        // }

        return ODRequestResultBuilder.getSuccessRequestResult();
    }

    /**
     * 자산 삭제
     * 
     * @param session
     * @param oid
     * @return
     */
    @RequestMapping(value = "/deleteAsset", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ODRequestResult deleteAsset(HttpSession session, long oid) {
        assetService.removeAsset(oid);
        return ODRequestResultBuilder.getSuccessRequestResult();
    }
}
