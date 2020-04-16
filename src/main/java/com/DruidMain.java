package com;

import com.druid.sql.SqlParserDruid;

public class DruidMain {

    public static void main(String[] args) throws Exception {

//        String sql = "INSERT INTO S_GL_INN_ACCOUNT_D" +
//                "(" +
//                "STATDATE" +
//                ",ACCTNBR" +
//                ",CCYNBR" +
//                ",BRNNBR" +
//                ",ITEMCODE" +
//                ",ITEMDR" +
//                ",BUSNTYP" +
//                ",ACCTNM" +
//                ")" +
//                "select * from ("+
//                "SELECT " +
//                "I_STATEDATE STATDATE" +
//                ",A.GL_ACCT_NO def" +
//                ",F_DEP_INN_GLACAACA.GL_CURR_COD_AUTHOR" +
//                ",func(A.GL_OPUN_COD,123)" +
//                ",A.GL_FIRST_LEVEL_LG_COD||GL_SECOND_LEVEL_LG_CD||GL_THIRD_LEVEL_LG_CD fd" +
//                ",CASE  WHEN LENGTH (A.PUTOUTDATE) IN (8,10) THEN TO_DATE (A.PUTOUTDATE,'YYYYMMDD')  WHEN LENGTH (A.PUTOUTDATE) IN (11,12) THEN SELECT \n" +
//                "                             OO.CM_INTR1 FROM  ods.O_CBOD_CMIRTIRT OO WHERE  CM_INTR_TYP ='B5'\n" +
//                "                         AND CM_IRT_STS = '0'  END AS KHRQ " +
//                ",'ave'" +
//                ",null " +
//                "FROM DC.F_DEP_INN_GLACAACA A " +
//                "LEFT JOIN TEST_TEST B ON A.GL_ACCT_NO=B.TEST_NO " +
//                "LEFT JOIN  DF.TEST_2 C ON A.GL_ACCT_NO=C.TEST_NO " +
//                "WHERE A.GL_ACCT_NO_2 > 0 )";
//

//        String sql ="INSERT INTO FDS.F_LN_ACCT(\n" +
//                "      ACCT_NO\n" +
//                "      ,CUST_FLG\n" +
//                "      ,CUST_NO\n" +
//                "      ,CUST_NAME\n" +
//                "      ,CERT_TYP\n" +
//                "      ,CERT_NO\n" +
//                "      ,CONT_NO\n" +
//                "      ,BILL_NO\n" +
//                "      ,CURR_CODE\n" +
//                "      ,CURR_IDEN\n" +
//                "      ,CRLMT_NO\n" +
//                "      ,PDP_CODE\n" +
//                "      ,LOAN_TYP\n" +
//                "      ,ORG_NO\n" +
//                "      ,LOAN_DUE\n" +
//                "      ,LOAN_PURP\n" +
//                "      ,LOAN_STP\n" +
//                "      ,LOAN_FUND_RSUR\n" +
//                "      ,LOAN_SVR_BUS\n" +
//                "      ,ACCT_STS\n" +
//                "      ,RFN_TYP\n" +
//                "      ,RFN_ACCT_NO\n" +
//                "      ,LOAN_BUS_TYP\n" +
//                "      ,LOAN_SULT_TYP\n" +
//                "      ,GL_ACC_NO\n" +
//                "      ,RFN_USE_DUE\n" +
//                "      ,RFN_LAST_DT\n" +
//                "      ,ACCT_BAL\n" +
//                "      ,ACCT_NOR_BAL\n" +
//                "      ,ACCT_DUE_BAL\n" +
//                "      ,OPEN_DT\n" +
//                "      ,LOAN_ACT_DT\n" +
//                "      ,LOAN_DUE_DT\n" +
//                "      ,RATE_DT\n" +
//                "      ,RATE_TYP\n" +
//                "      ,LOAN_CLSD_TYP\n" +
//                "      ,LOAN_RATE\n" +
//                "      ,CLOSE_DT\n" +
//                "      ,TLR_NO\n" +
//                "      ,COMP_INT_END_DT\n" +
//                "      ,COMP_RATE\n" +
//                "      ,APCL_FLG\n" +
//                "      ,CRNT_YR_INTRBL\n" +
//                "      ,RMRK\n" +
//                "      ,GUAR_TYP\n" +
//                "      ,RFN_DUE\n" +
//                "      ,CRLMT_BAL\n" +
//                "      ,CRLMT_USE_BAL\n" +
//                "      ,LOAN_COG_LVL\n" +
//                "      ,COMP_INT_FLG\n" +
//                "      ,ACCU_COMP_INT\n" +
//                "      ,COMP_INT_AMT\n" +
//                "      ,LOAN_BUY_INT\n" +
//                "      ,ETL_DT\n" +
//                "   )WITH T1 AS (SELECT * FROM (SELECT LNS.LN_ENTR_DT_N,LNS.LN_LN_ACCT_NO,ROW_NUMBER() OVER(PARTITION BY LN_LN_ACCT_NO ORDER BY LN_ENTR_DT_N DESC) RN FROM ODS.O_CBOD_LNLNSJRN0 LNS) WHERE RN=1)\n" +
//                "      SELECT \n" +
//                "      fun(A.ACCT_NO,A.CUST_TYP,E.BUS_TYP)\n" +
//                "      ,A.CUST_TYP\n" +
//                "      ,A.CUST_NO\n" +
//                "      ,A.CUST_NAME\n" +
//                "      ,A.CERT_TYP\n" +
//                "      ,A.CERT_ID\n" +
//                "      ,E.CONT_NO\n" +
//                "      ,E.BILL_NO\n" +
//                "      ,A.CURR_CODE\n" +
//                "      ,A.CURR_IDEN\n" +
//                "      ,A.CRLMT_NO\n" +
//                "      ,A.PDP_CODE\n" +
//                "      ,A.LN_TYP\n" +
//                "      ,A.BELONG_INSTN_CODE\n" +
//                "      ,A.LN_MTHS\n" +
//                "      ,A.LN_PURP\n" +
//                "      ,A.LN_STY\n" +
//                "      ,A.LN_FUND_RSUR\n" +
//                "      ,D.DIRECTION\n" +
//                "      ,A.ACCT_STS\n" +
//                "      ,A.RFN_STY\n" +
//                "      ,A.DEP_ACCT_NO\n" +
//                "      ,E.BUS_TYP\n" +
//                "      ,E.LASTCLASSIFYRESULT\n" +
//                "      ,B.ACC_NO\n" +
//                "      ,A.ARFN_SCHD_PR\n" +
//                "      ,C.LN_ENTR_DT_N\n" +
//                "      ,A.LN_BAL\n" +
//                "      ,A.TOTL_LN_AMT_HYPO_AMT\n" +
//                "      ,A.DLAY_PR_TOTL\n" +
//                "      ,A.FLST_DT\n" +
//                "      ,A.FRST_ALFD_DT\n" +
//                "      ,A.DUE_DT\n" +
//                "      ,A.FRST_ALFD_DT\n" +
//                "      ,A.INTR_TYP\n" +
//                "      ,A.CLSD_INTC_TYP\n" +
//                "      ,A.FRST_INTC_INTR\n" +
//                "      ,A.CLSD_DT\n" +
//                "      ,A.LTST_MNTN_OPR_NO\n" +
//                "      ,A.INT_DIS_END_DT\n" +
//                "      ,A.INT_DIS_RATE\n" +
//                "      ,A.APCL_FLG\n" +
//                "      ,A.CRNT_YR_INTRBL\n" +
//                "      ,A.RMRK\n" +
//                "      ,D.VOUCHTYPE\n" +
//                "      ,E.PAYCYC\n" +
//                "      ,'0.00'\n" +
//                "      ,'0.00'\n" +
//                "      ,''\n" +
//                "      ,''\n" +
//                "      ,'0.00'\n" +
//                "      ,'0.00'\n" +
//                "      ,''\n" +
//                "      ,A.ETL_DT\n" +
//                "      FROM F_LN_LNLNSLNS A LEFT JOIN ODS.O_ODS_F_PRD_PDP_LOAN B ON A.BUS_TYP=B.LOAN_TYP\n" +
//                "      \t\t\t\t\t   LEFT JOIN T1 C ON A.ACCT_NO=C.LN_LN_ACCT_NO\n" +
//                "      \t\t\t\t\t   LEFT JOIN F_LN_BUSINESS_DUEBILL E ON A.ACCT_NO = E.ACCT_NO \n" +
//                "      \t\t\t\t\t   LEFT JOIN  FDS.F_LN_BUSINESS_CONTRACT D ON   E.CONT_NO=D.CONT_NO\n" +
//                "      ;";


//        String sql="INSERT INTO SESSION.N_F_LN_BUSINESS_PUTOUT_H(\n" +
//                "        SERIALNO\n" +
//                "        ,CONTRACTSERIALNO\n" +
//                "        ,MFCUSTOMERID\n" +
//                "        ,CUSTOMERID\n" +
//                "       \n" +
//                "    \n" +
//                "       )  SELECT\n" +
//                "      A.SERIALNO\n" +
//                "      ,A.CONTRACTSERIALNO\n" +
//                "      ,B.MFCUSTOMERID\n" +
//                "      ,A.CUSTOMERID\n" +
//                "     \n" +
//                "      FROM ODS.O_CMIS_BUSINESS_PUTOUT A LEFT JOIN ODS.O_CMIS_CUSTOMER_INFO B ON A.CUSTOMERID=B.CUSTOMERID\n" +
//                "      WHERE  A.ETL_DT = I_STATEDATE \n" +
//                "      UNION  SELECT\n" +
//                "        VC.SERIALNO_VC\n" +
//                "        ,VC.CONTRACTSERIALNO_VC\n" +
//                "        ,VC.MFCUSTOMERID_VC\n" +
//                "        ,VC.CUSTOMERID_VC\n" +
//                "      \n" +
//                "      FROM  FDS.F_LN_BUSINESS_PUTOUT_H VC\n" +
//                "     ";


        String sql="INSERT INTO DM_RPT.CORP_CUST_INFO\n" +
                "  (DATA_DT,\n" +
                "   OPN_ORG,\n" +
                "   CUST_ID,\n" +
                "   CUST_CN_NAME,\n" +
                "   CERTNO,\n" +
                "   RGST_ADDR,\n" +
                "   CORP_SIZE,\n" +
                "   CUST_BELONG_INDUSTRY,\n" +
                "   CNNAME,\n" +
                "   HXACTORNO,\n" +
                "   ACTORNAME,\n" +
                "   BJZH,\n" +
                "   SXKH,\n" +
                "   DFGZ,\n" +
                "   QYWY,\n" +
                "   CUST_CRD_LMT,\n" +
                "   ACCT_CNY_BAL,\n" +
                "   ACCT_YB_BAL,\n" +
                "   ACCT_RMB_BAL,\n" +
                "   NOTEM,\n" +
                "   AMOUNT,\n" +
                "   SECURITY_ACCT,\n" +
                "   YPRISK_OPEN_AMT,\n" +
                "   DFGZBS,\n" +
                "   DFGZ_AMT,\n" +
                "   LOAN_BALANCE_SJ,\n" +
                "   LOAN_BALANCE_WJ,\n" +
                "   DK,\n" +
                "   LOAN_BALANCE_XY,\n" +
                "   LOAN_BALANCE_BZ,\n" +
                "   LOAN_BALANCE_DY,\n" +
                "   LOAN_BALANCE_ZY,\n" +
                "   LOAN_BALANCE_DFZY,\n" +
                "   LOAN_BALANCE_DF)\n" +
                "\n" +
                "WITH  table3 as (SELECT D.CUST_ID,\n" +
                "SUM(CASE\n" +
                "         WHEN D.CURR_CD <> '01' AND D.BUSI_TYPE = '01' AND\n" +
                "              D.SUBJ NOT LIKE '1321%' AND D.SUBJ NOT LIKE '9%' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) ACCT_YB_BAL,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.CURR_CD = '01' AND D.BUSI_TYPE = '01' AND\n" +
                "              D.SUBJ NOT LIKE '1321%' AND D.SUBJ NOT LIKE '9%' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) ACCT_RMB_BAL,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.BUSI_TYPE = '04' THEN\n" +
                "          D.LOAN_AMOUNT\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) NOTEM,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.BUSI_TYPE = '02' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) AMOUNT,\n" +
                "        SUM(CASE\n" +
                "         WHEN D.BUSI_TYPE = '02' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) AS YPRISK_OPEN_AMT --敞口含保证金，要剪掉\n" +
                "FROM CMDATA.C_D_LOAN_ALL D --信贷各项业务明细合并表\n" +
                "      WHERE  D.DATA_DT = V_DATA_DT\n" +
                "         AND D.ACCOUNT_STATUS <> '0'\n" +
                "       GROUP BY D.CUST_ID )，\n" +
                " table7 as (SELECT D.CUST_ID,\n" +
                "SUM(CASE\n" +
                "          WHEN TRIM(D.CLA) IN ('30', '40', '50') THEN\n" +
                "           D.LOAN_BALANCE\n" +
                "          ELSE\n" +
                "           0\n" +
                "        END) LOAN_BALANCE_SJ， SUM(CASE\n" +
                "     WHEN TRIM(D.ACCOUNT_STATUS) IN\n" +
                "          ('3', '4', '5') THEN\n" +
                "      D.LOAN_BALANCE\n" +
                "     ELSE\n" +
                "      0\n" +
                "   END) LOAN_BALANCE_WJ,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.LOAN_TYPE = '3' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) DK,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.ASSURE_MEANS_MAIN = '00' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) LOAN_BALANCE_XY,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.ASSURE_MEANS_MAIN = '30' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) LOAN_BALANCE_BZ,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.ASSURE_MEANS_MAIN = '10' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) LOAN_BALANCE_DY,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.ASSURE_MEANS_MAIN = '20' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) LOAN_BALANCE_ZY,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.ASSURE_MEANS_MAIN = '21' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) LOAN_BALANCE_DFZY,\n" +
                "   SUM(CASE\n" +
                "         WHEN D.ASSURE_MEANS_MAIN = '50' THEN\n" +
                "          D.LOAN_BALANCE\n" +
                "         ELSE\n" +
                "          0\n" +
                "       END) LOAN_BALANCE_DF\n" +
                "from  CMDATA.C_D_LOAN_INFO D\n" +
                "      WHERE  D.DATA_DT = V_DATA_DT\n" +
                "     AND D.SUBJ NOT LIKE '1321%' --提出委托贷款\n" +
                "     AND D.SUBJ NOT LIKE '9%' --剔除表外贷款\n" +
                "     AND D.LOAN_TYPE IN ('01', '03') --对公普通贷款、垫款\n" +
                "     AND D.ACCOUNT_STATUS <> '0'\n" +
                "     GROUP BY D.CUST_ID\n" +
                "     )\n" +



                "SELECT /*+ordered use_hash(t t1 t2 t3 t4 t5 t6 t7 t8 t9 t10)*/\n" +
                "   T.DATA_DT,\n" +
                "   T.OPN_ORG,\n" +
                "   T.CUST_ID,\n" +
                "   T.CUST_CN_NAME,\n" +
                "   T1.CERTNO,\n" +
                "   T.RGST_ADDR,\n" +
                "   DECODE(T.CORP_SIZE,\n" +
                "          'S10',\n" +
                "          '大型企业',\n" +
                "          'S20',\n" +
                "          '中型企业',\n" +
                "          'S30',\n" +
                "          '小型企业',\n" +
                "          'S31',\n" +
                "          '微型企业',\n" +
                "          'S40',\n" +
                "          '集团企业',\n" +
                "          'S90',\n" +
                "          '非企业单位') CORP_SIZE,\n" +
                "   T.CUST_BELONG_INDUSTRY,\n" +
                "   T8.CNNAME,\n" +
                "   T10.HXACTORNO,\n" +
                "   T10.ACTORNAME,\n" +
                "   CASE\n" +
                "     WHEN  TRIM(T.BASIC_ACCT) IS NULL  THEN\n" +
                "      '否'\n" +
                "     ELSE\n" +
                "      '是'\n" +
                "   END BJZH,\n" +
                "   CASE\n" +
                "     WHEN  TRIM(T5.CUS_ID) IS NULL  THEN\n" +
                "      '否'\n" +
                "     ELSE\n" +
                "      '是'\n" +
                "   END SXKH,\n" +
                "   CASE\n" +
                "     WHEN  TRIM(T6.CUSTNO) IS NULL THEN\n" +
                "      '否'\n" +
                "     ELSE\n" +
                "      '是'\n" +
                "   END DFGZ,\n" +
                "   CASE\n" +
                "     WHEN T.EBK_IDTFY = '1' THEN\n" +
                "      '是'\n" +
                "     ELSE\n" +
                "      '否'\n" +
                "   END QYWY,\n" +
                "   T5.CUST_CRD_LMT,\n" +
                "   T2.ACCT_CNY_BAL,\n" +
                "   T3.ACCT_YB_BAL,\n" +
                "   T3.ACCT_RMB_BAL,\n" +
                "   T3.NOTEM,\n" +
                "   T3.AMOUNT,\n" +
                "   T2.SECURITY_ACCT,\n" +
                "    T3.YPRISK_OPEN_AMT, --敞口含保证金，要剪掉\n" +
                "   T6.SUCCNO DFGZBS,\n" +
                "   T6.SUCCAM DFGZ_AMT,\n" +
                "   T7.LOAN_BALANCE_SJ，\n" +
                "   T7.LOAN_BALANCE_WJ,\n" +
                "   T7.DK,\n" +
                "   T7.LOAN_BALANCE_XY,\n" +
                "   T7.LOAN_BALANCE_BZ,\n" +
                "   T7.LOAN_BALANCE_DY,\n" +
                "   T7. LOAN_BALANCE_ZY,\n" +
                "  T7.LOAN_BALANCE_DFZY,\n" +
                "  T7.LOAN_BALANCE_DF\n" +
                "\n" +
                "    FROM CMDATA.C_D_CUST_CPRO T --对公客户基本信息表\n" +
                "\n" +
                "    LEFT JOIN OMDATA.CIF_CIFS_AID_CERT T1\n" +
                "      ON T.CUST_ID = T1.CUSTNO\n" +
                "     AND T1.MAINFG = '1'\n" +
                "     AND T1.CERTTP = 'V'\n" +
                "     AND T1.START_DT <= V_DATA_DT\n" +
                "     AND T1.END_DT > V_DATA_DT\n" +
                "\n" +
                "    LEFT JOIN (\n" +
                "    SELECT D.CUST_ID,SUM(D.ACCT_BAL) AS ACCT_BAL,\n" +
                "    SUM(CASE WHEN D.SUBJECT LIKE '2014%' THEN D.ACCT_BAL ELSE 0 END) AS SECURITY_ACCT,\n" +
                "    SUM(D.ACCT_CNY_BAL) AS ACCT_CNY_BAL\n" +
                "    FROM  CMDATA.C_D_ACCT_DEPT_bal D --存款帐户表\n" +
                "      WHERE D.DATA_DT = V_DATA_DT\n" +
                "           AND D.CUST_TYPE IN ('2','4','8')\n" +
                "           GROUP BY D.CUST_ID\n" +
                "     ) T2\n" +
                "      ON T.CUST_ID = T2.CUST_ID\n" +
                "\n" +
                "    LEFT JOIN table3 T3 --信贷各项业务明细合并表\n" +
                "      ON T3.CUST_ID = T.CUST_ID\n" +
                "\n" +
                "    LEFT JOIN OMDATA.CMS_CUS_BASE T4 --客户共用基表\n" +
                "      ON T4.OUT_CUS_ID = T.CUST_ID\n" +
                "     AND T4.START_DT <= V_DATA_DT\n" +
                "     AND T4.END_DT > V_DATA_DT\n" +
                "\n" +
                "    LEFT JOIN DM_RPT.DM_RPT_CUST_CRD_LMT T5\n" +
                "      ON T5.CUS_ID = T4.CUS_ID\n" +
                "     AND T5.DATA_DT = V_DATA_DT\n" +
                "\n" +
                "    LEFT JOIN (SELECT d2.data_dt,\n" +
                "                      D1.CUSTNO,\n" +
                "                      --SUM(D2.SUCCNO) SUCCNO,\n" +
                "                      0 as  SUCCNO,\n" +
                "                      --SUM(D2.SUCCAM) SUCCAM\n" +
                "                      0 as SUCCAM\n" +
                "                 FROM OMDATA.CBS_KNC_ACID D1, --客户与标识对应\n" +
                "                      DM_RPT.DM_RPT_07048 D2\n" +
                "                WHERE D2.ACCTNO = D1.DATAVL\n" +
                "                  AND D1.DATATP = '1' --数据种类\n" +
                "                  AND D1.START_DT <= V_DATA_DT\n" +
                "                  AND D1.END_DT > V_DATA_DT\n" +
                "                GROUP BY D2.DATA_DT, D1.CUSTNO) T6\n" +
                "      ON T6.CUSTNO = T.CUST_ID\n" +
                "     AND T6.DATA_DT = V_DATA_DT\n" +
                "\n" +
                "    LEFT JOIN table7  T7\n" +
                "      ON T7.CUST_ID = T.CUST_ID\n" +
                "\n" +
                "    LEFT JOIN OMDATA.CMS_S_TREEDIC T8\n" +
                "      ON T8.OPTTYPE = 'STD_GB_4754-2002'\n" +
                "     AND T8.ENNAME = SUBSTR(T.CUST_BELONG_INDUSTRY, 2, 4)\n" +
                "\n" +
                "    LEFT JOIN OMDATA.CMS_CUS_COM T9 --对公客户基本信息表\n" +
                "      ON T9.CUS_ID = T4.CUS_ID\n" +
                "     AND T9.START_DT <= V_DATA_DT\n" +
                "     AND T9.END_DT > V_DATA_DT\n" +
                "\n" +
                "    LEFT JOIN OMDATA.CMS_S_USER T10 --用户表\n" +
                "      ON T10.ACTORNO = T9.CUST_MGR\n" +
                "     AND T10.START_DT <= V_DATA_DT\n" +
                "     AND T10.END_DT > V_DATA_DT\n" +
                "\n" +
                "   WHERE T.DATA_DT = V_DATA_DT";
        SqlParserDruid.opSqlTargetResourceByDruid(sql, "");

    }
}
