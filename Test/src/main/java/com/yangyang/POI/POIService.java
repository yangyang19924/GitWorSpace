package com.yangyang.POI;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyang on 2018/8/20.
 */
public class POIService {

//    private List<ReqPOIQuestionDTO> getDataFromExcel(InputStream in) throws Exception {
//        POIUtils poi = new POIUtils(in);
//        // 获取所有sheet页
//        List<String> sheets = poi.getSheetNames();
//        // 校验
//        if (sheets == null || sheets.size() == 0) {
//            throw new BaseException(ExceptionCategory.Illegal_Parameter,
//                    "excel为空，请检查！");
//        }
//        List<ReqPOIQuestionDTO> result = new ArrayList<ReqPOIQuestionDTO>();
//        for (String sheet : sheets) {
//            if ("sheet1".equals(sheet)) {// 固定去“试题”sheet页
//                // 该sheet页数据
//                List<String[]> dataList = poi.getContentBySheetName(sheet);
//                // 该sheet页表头
//                List<String> head = poi.getHeadBySheetName(sheet);
//                // 校验
//                if (dataList == null || dataList.size() <= 0) {
//                    throw new BaseException(
//                            ExceptionCategory.Illegal_Parameter,
//                            "Excel内容为空，请检查！");
//                }
//                if (head.size() <= 0) {
//                    throw new BaseException(
//                            ExceptionCategory.Illegal_Parameter,
//                            "Excel表头为空，请检查！");
//                }
//
//                List<String> existingType = new ArrayList<String>();
//                for (int i = 0; i < dataList.size(); i++) {
//                    String[] arr = dataList.get(i);
//                    //校验必填项
//                    validateRequiredCell(arr, i + 2, head);
//                    //校验部分单元格的数据类型
//                    validateDataContent(arr, i + 2, head);
//                    //校验题型是否连续
//                    validateSerialQuestionType(arr, i + 2, head, existingType);
//                    //校验其他规则
//                    validateOtherRules(arr, i + 2, head);
//                    result.add(new ReqPOIQuestionDTO(head, arr));
//                }
//            }
//        }
//        in.close();
//        return result;
//    }
//
//    //校验必填项
//    private void validateRequiredCell(String[] arr, int rowIndex, List<String> head) {
//        if (arr == null || arr.length < PaperTemplateConstants.REQUIRED_CELL_INDEXS.size()) {
//            logger.error("第{}行填写不完整", rowIndex);
//            throw new RuntimeException("第" + rowIndex + "行" + "填写不完整");
//        } else {
//            for (Integer index : PaperTemplateConstants.REQUIRED_CELL_INDEXS) {
//                if (EntStringUtil.isEmpty(arr[index])) {
//                    logger.error("第{}行{}字段不可为空", rowIndex, head.get(index));
//                    throw new RuntimeException("第" + rowIndex + "行" + head.get(index) + "字段不可为空");
//                }
//            }
//        }
//    }
//
//    //校验部分单元格的数据类型
//    private void validateDataContent(String[] arr, int rowIndex, List<String> head) {
//        String questionType = arr[PaperTemplateConstants.INDEX_QUESTION_TYPE];
//        String score = arr[PaperTemplateConstants.INDEX_SCORE];
//        //题目类型
//        if (questionType == null || !PaperTemplateConstants.SUPPORTED_QUESTION_TYPES.contains(questionType)) {
//            logger.error("第{}行题目类型不正确", rowIndex);
//            throw new RuntimeException("第" + rowIndex + "行" + "题目类型不正确");
//        }
//        //分值为数字
//        if (score == null || !EntStringUtil.isFloatWithin2Digits(score)) {
//            logger.error("第{}行题目分值不为数字或小数位超过2位", rowIndex);
//            throw new RuntimeException("第" + rowIndex + "行" + "题目分值不为数字或小数位超过2位");
//        }
//
//    }
}
