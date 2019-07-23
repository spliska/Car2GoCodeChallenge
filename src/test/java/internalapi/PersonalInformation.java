package internalapi;

import api.internal.api.InternalApi;

import api.internal.personaldata.PersonalDataResponse;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonalInformation {
    @Test(dataProvider = "personalInformationData")
    public void getPersonalInformationCall(PersonalDataResponse personalDataResponse){

        InternalApi internalApi=new InternalApi();
        Gson gson =new Gson();
        
        Assert.assertEquals(personalDataResponse.getBody().getPersonalDataRTO(), gson.fromJson(internalApi.getPersonalData().body().asString(), PersonalDataResponse.class ).getBody().getPersonalDataRTO());







    }


    @DataProvider
    public Object[][] personalInformationData(){
        Gson gson=new Gson();

        return new Object[][]{{gson.fromJson("{\"body\":{\"PersonalDataRTO\":{\"salutation\":\"FRAU\",\"firstName\":\"Nils\",\"lastName\":\"Reißig\",\"addressStreet\":\"Test street\",\"addressAdditionalStreet\":\"testNumber1551224036901\",\"addressZipCode\":\"12345\",\"addressCity\":\"Testaccount\",\"addressCountryIsoCode\":\"DE\",\"language\":\"de_DE\",\"birthDate\":\"1978,11,3,0,0,0,UTC\",\"birthPlace\":\"Test birth place\",\"mobilePhone\":\"+*************2210\",\"email\":\"nils.reissig+manuel@gmail.com\",\"emailInValidation\":\"nils.reissig+manuel@gmail.com-email\",\"student\":\"false\",\"fullTimeStudent\":\"false\"}},\"meta\":{\"metaDataList\":[{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressAdditionalStreet\",\"validator\":\"pattern\",\"parameter\":\"[\\\\w\\\\W@#\\\\$&()-:/\\\\.,\\\"' åáąàãâäæçćéęèêëíìîïłńñóøòóôõöśßùúûüÿýźżÁĄÀÃÂÅÄÆÇĆÉÈÊĘËËÌÍÎÏŁÑŃÓÒÔÕÓÖØŚÜÚÛÙÝŸŹŻ]*\",\"messageKey\":\"javax.validation.constraints.Pattern.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressAdditionalStreet\",\"validator\":\"rangelength\",\"parameter\":\"0:100\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Size.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressCity\",\"validator\":\"pattern\",\"parameter\":\"[\\\\w\\\\W@#\\\\$&()-:/\\\\.,\\\"' åáąàãâäæçćéęèêëíìîïłńñóøòóôõöśßùúûüÿýźżÁĄÀÃÂÅÄÆÇĆÉÈÊĘËËÌÍÎÏŁÑŃÓÒÔÕÓÖØŚÜÚÛÙÝŸŹŻ]*\",\"messageKey\":\"javax.validation.constraints.Pattern.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressCity\",\"validator\":\"rangelength\",\"parameter\":\"0:100\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Size.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressCity\",\"validator\":\"required\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotNull.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressCountryIsoCode\",\"validator\":\"isocountrycode\",\"messageKey\":\"javax.validation.constraints.CountryIsoCode.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressCountryIsoCode\",\"validator\":\"required\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotNull.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressProvinceIsoCode\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressStreet\",\"validator\":\"pattern\",\"parameter\":\"[\\\\w\\\\W@#\\\\$&()-:/\\\\.,\\\"' åáąàãâäæçćéęèêëíìîïłńñóøòóôõöśßùúûüÿýźżÁĄÀÃÂÅÄÆÇĆÉÈÊĘËËÌÍÎÏŁÑŃÓÒÔÕÓÖØŚÜÚÛÙÝŸŹŻ]*\",\"messageKey\":\"javax.validation.constraints.Pattern.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressStreet\",\"validator\":\"rangelength\",\"parameter\":\"0:100\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Size.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressStreet\",\"validator\":\"required\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotNull.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressZipCode\",\"validator\":\"pattern\",\"parameter\":\"[0-9]*\",\"messageKey\":\"javax.validation.constraints.Pattern.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressZipCode\",\"validator\":\"rangelength\",\"parameter\":\"5:5\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Size.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"addressZipCode\",\"validator\":\"required\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotNull.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"birthCountryIsoCode\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"birthDate\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"birthDate\",\"validator\":\"noteditable\",\"parameter\":\"true\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"birthPlace\",\"validator\":\"pattern\",\"parameter\":\"[\\\\w\\\\W]*\",\"messageKey\":\"javax.validation.constraints.Pattern.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"birthPlace\",\"validator\":\"rangelength\",\"parameter\":\"0:100\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Size.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"birthPlace\",\"validator\":\"required\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotNull.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"email\",\"validator\":\"email\",\"parameter\":\".*\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Email.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"email\",\"validator\":\"negativepattern\",\"parameter\":\".*@10minutemail\\\\.com|.*@dreggn\\\\.com|.*\\\\.@.*\",\"messageKey\":\"javax.validation.constraints.NegativePattern.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"email\",\"validator\":\"rangelength\",\"parameter\":\"0:320\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Size.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"email\",\"validator\":\"required\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotNull.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"emailInValidation\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"firstName\",\"validator\":\"noteditable\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotEditable.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"fiscalCode\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"fullTimeStudent\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"language\",\"validator\":\"listmatch\",\"parameter\":\"en_DE|de_DE\",\"messageKey\":\"javax.validation.constraints.ListMatch.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"lastName\",\"validator\":\"noteditable\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotEditable.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"login\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"login\",\"validator\":\"noteditable\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotEditable.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"middleName\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"middleName\",\"validator\":\"pattern\",\"parameter\":\"[\\\\w\\\\W@#\\\\$&()-:/\\\\.,\\\"' åáąàãâäæçćéęèêëíìîïłńñóøòóôõöśßùúûüÿýźżÁĄÀÃÂÅÄÆÇĆÉÈÊĘËËÌÍÎÏŁÑŃÓÒÔÕÓÖØŚÜÚÛÙÝŸŹŻ]*\",\"messageKey\":\"javax.validation.constraints.Pattern.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"middleName\",\"validator\":\"rangelength\",\"parameter\":\"0:100\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Size.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"mobilePhone\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"mobilePhone\",\"validator\":\"noteditable\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.NotEditable.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"mobilePhoneInValidation\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"passportId\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"phone\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"salutation\",\"validator\":\"listmatch\",\"parameter\":\"HERR|FRAU\",\"messageKey\":\"javax.validation.constraints.ListMatch.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"student\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"},{\"object\":\"PersonalDataRTO\",\"attribute\":\"title\",\"validator\":\"invisible\",\"parameter\":\"true\",\"messageKey\":\"com.daimler.cs.beanvalidation.constraint.Invisible.message\"}]}}", PersonalDataResponse.class)}};
    }
}