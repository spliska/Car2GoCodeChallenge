package api.internal;

import java.util.Arrays;

public class Meta {
    private MetaData[] metaDataArray;

    public Meta(MetaData[] metaDataList) {
        this.metaDataArray = metaDataList;
    }

    public MetaData[] getMetaDataArray() {
        return metaDataArray;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(Meta.class)) {
            Meta castMetaData = (Meta) object;
            return Arrays.equals(this.getMetaDataArray(), castMetaData.getMetaDataArray());


        } else {
            return false;
        }
    }
}
