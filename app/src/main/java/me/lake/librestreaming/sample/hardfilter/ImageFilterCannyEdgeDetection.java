package me.lake.librestreaming.sample.hardfilter;


import jp.co.cyberagent.android.gpuimage.filter.GPUImageDirectionalSobelEdgeDetectionFilter;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageNonMaximumSuppressionFilter;
import me.lake.librestreaming.filter.hardvideofilter.BaseHardVideoFilter;
import me.lake.librestreaming.filter.hardvideofilter.HardVideoGroupFilter;
import me.lake.librestreaming.sample.hardfilter.extra.GPUImageCompatibleFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwb on 2017/3/30.
 */
public class ImageFilterCannyEdgeDetection extends HardVideoGroupFilter {

    public ImageFilterCannyEdgeDetection(List<BaseHardVideoFilter> filters) {
        super(filters);
    }

    public static ImageFilterCannyEdgeDetection newInstance(float blurSize) {
        ArrayList<BaseHardVideoFilter> filters = new ArrayList<>();
        BaseHardVideoFilter baseHFilter = new ImageGrayscaleFilter();
        filters.add(baseHFilter);
        baseHFilter = new GPUImageCompatibleFilter(new GPUImageDirectionalSobelEdgeDetectionFilter());
        filters.add(baseHFilter);
        baseHFilter = new GPUImageCompatibleFilter(new GPUImageNonMaximumSuppressionFilter());
        filters.add(baseHFilter);

        ImageFilterCannyEdgeDetection cannyEdgeDetection = new ImageFilterCannyEdgeDetection(filters);
        return cannyEdgeDetection;
    }
}
