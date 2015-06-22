package org.dongchimi.odong.accountbook.web.resource;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.dongchimi.odong.accountbook.domain.Asset;
import org.dongchimi.odong.accountbook.domain.AssetType;
import org.dongchimi.odong.accountbook.service.AssetService;
import org.dongchimi.odong.accountbook.web.util.ODRequestResult;
import org.dongchimi.odong.accountbook.web.util.ODRequestResultBuilder;
import org.dongchimi.odong.accountbook.web.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis/assets")
public class ODAssetResource {

    @Autowired
    private AssetService assetService;

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
        
        List<Asset> assets = assetService.findAssets(currentAccountBookOid);
        
        return ODRequestResultBuilder.getSuccessRequestResult(assets);
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
    ODRequestResult setAsset(HttpSession session, @RequestParam String assetType,
            @RequestParam String name, @RequestParam int balance, @RequestParam String memo) {

        Long currentAccountBookOid = (Long) session
                .getAttribute(SessionManager.SESSION_KEY_CURRENT_ACCOUNT_BOOK_OID);
        
        Asset asset = new Asset(AssetType.toAssetType(assetType), name, balance, memo, currentAccountBookOid);
        assetService.registerAsset(asset);

        return ODRequestResultBuilder.getSuccessRequestResult();
    }
}
