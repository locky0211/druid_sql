package com;

import com.druid.sql.SqlParserDruid;

public class DruidMain {

    public static void main(String[] args) throws Exception {

        String sql11 = "INSERT INTO S_GL_INN_ACCOUNT_D" +
                "(" +
                "STATDATE" +
                ",ACCTNBR" +
                ",CCYNBR" +
                ",BRNNBR" +
                ",ITEMCODE" +
                ",ITEMDR" +
                ",BUSNTYP" +
                ",ACCTNM" +
                ")" +
                "select * from ("+
                "SELECT " +
                "I_STATEDATE STATDATE" +
                ",C.GL_ACCT_NO def" +
                ",F_DEP_INN_GLACAACA.GL_CURR_COD_AUTHOR" +
                ",func(A.GL_OPUN_COD,123)" +
                ",A.GL_FIRST_LEVEL_LG_COD fd" +
                ",CASE  WHEN LENGTH (A.PUTOUTDATE) IN (8,10) THEN TO_DATE (A.PUTOUTDATE,'YYYYMMDD')  WHEN LENGTH (A.PUTOUTDATE) IN (11,12) THEN SELECT \n" +
                "                             OO.CM_INTR1 FROM  ods.O_CBOD_CMIRTIRT OO WHERE  CM_INTR_TYP ='B5'\n" +
                "                         AND CM_IRT_STS = '0'  END AS KHRQ " +
                ",'ave'" +
                ",null " +
                "FROM DC.F_DEP_INN_GLACAACA A " +
                "LEFT JOIN TEST_TEST B ON A.GL_ACCT_NO=B.TEST_NO " +
                "LEFT JOIN  JNCREDIT66.S_DIC@cms C ON A.GL_ACCT_NO=C.TEST_NO " +
                "WHERE A.GL_ACCT_NO_2 > 0 )";


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


        String sql2 = " INSERT INTO CMDATA.C_D_LOAN_CUST_CPRO\n" +
                "    (DATA_DT, --????\n" +
                "     CUS_ID, --???\n" +
                "     CUS_NAME, --????\n" +
                "     LOAN_CUST_ID, --?????\n" +
                "     GUARANTEE_INSURANCE, --????\n" +
                "     FIN_LINKMAN, --??????\n" +
                "     FIN_CONT_MODE, --?????/???????\n" +
                "     INDUSTRY_NAME, --????\n" +
                "     CHANGZHOU_TECH_ENTERPRISE, --???\n" +
                "     COM_STR_DATE, --????\n" +
                "     INVT_AMT, --????????\n" +
                "     LOAN_CARD, --????????\n" +
                "     INVT_NAME, --?????\n" +
                "     CERT_CODE_NUM, --???????\n" +
                "     CERT_TYP, --???????std_zb_cert_typ\n" +
                "     FAX_NUM, --????\n" +
                "     COM_EMPLOYEE, --????\n" +
                "     LOAN_CARD_NUM, --????\n" +
                "     INPUT_BR_ID, --????\n" +
                "     INPUT_DATE, --????\n" +
                "     REG_CODE, --?????\n" +
                "     RGST_RGST_TYPE, --??????\n" +
                "     REG_AREA_NAME, --????\n" +
                "     EMAIL, --????\n" +
                "     LEGAL_NAME, --???????\n" +
                "     LEGAL_CERT_NUM, --????????\n" +
                "     LEGAL_CERT_TYPE, --????????\n" +
                "     RISK_POOL, --???\n" +
                "     BIG_RISK_CLASS, --????\n" +
                "     EVENT_TYPE, --??????\n" +
                "     LAST_UPD_ID, --???\n" +
                "     LAST_UPD_DATE, --????\n" +
                "     STOCK_CD, --????\n" +
                "     RELA_CUST_TYPE, --?????\n" +
                "     COM_CLL_TYPE, --????\n" +
                "     COM_CLL_NAME, --????\n" +
                "     AERA_CD, --??????\n" +
                "     BASIC_ACCT, --?????\n" +
                "     BASIC_ACCT_OPEN_ACCT_DT, --????????\n" +
                "     GROUP_CORP_IDTFY, --??????\n" +
                "     EXP_RIGHT_IDTFY, --??????\n" +
                "     OPER_FIELD_AREA, --??????\n" +
                "     OPER_FIELD_PROP, --???????\n" +
                "     OPER_SITU, --????\n" +
                "     CERT_CODE, --??????\n" +
                "     CERT_TYPE, --??????std_zb_cert_typ\n" +
                "     TECH_FLAG, --???????\n" +
                "     CUST_MGER, --????\n" +
                "     CUS_TYPE, --????std_zb_cus_type\n" +
                "     CUST_BELONG_INDUSTRY, --??????\n" +
                "     CRDT_RATING, --??????\n" +
                "     RISK_DES, --????????\n" +
                "     HOLD_TYPE, --????\n" +
                "     CONT_TEL, --????\n" +
                "     PRIVATE_ENTERPRISE, --??\n" +
                "     CORP_SIZE, --????\n" +
                "     CORP_RGST_FDG_DAY, --???????\n" +
                "     ISRH, --????\n" +
                "     BLACK_DATE, --??????\n" +
                "     BLACK_REASON, --??????\n" +
                "     LAST_YEAREND_TOTAL_ASSET, --??????\n" +
                "     LIST_CORP_IDTFY, --??????\n" +
                "     COM_CITY_SUBITEM, --??????std_zb_citytown\n" +
                "     FARM_TYPE, --????\n" +
                "     PROVINCE_TECH_ENTERPRISE, --???\n" +
                "     ACU_ADDR, --??????\n" +
                "     RECV_DCURR_TYP, --??????\n" +
                "     RECV_CAP_AMT, --??????\n" +
                "     ISTYPEA, --??a??????\n" +
                "     HOME_FARM, --??????std_zx_yes_no\n" +
                "     FIRST_CRDT_RELA_DT, --??????????\n" +
                "     CREDIT_LIMIT_FLAG, --??????\n" +
                "     MNG_BR_ID, --??????\n" +
                "     GROUP_NO, --?????\n" +
                "     GROUP_NAME, --??????\n" +
                "     CZ_AREA, --????std_zb_cz_area\n" +
                "     SALE_ASS, --???(?)\n" +
                "     COM_CRD_GRADE, --????(??)std_zb_credit_grade\n" +
                "     COM_OUT_CRD_GRADE, --????(??)std_zb_credit_grade\n" +
                "     COM_CRD_DT, --??????\n" +
                "     ONENUCLEAR_EIGHTGARDEN, --????\n" +
                "     ZIP_CD, --????\n" +
                "     CERT_EFFECT_DT, --??????\n" +
                "     CERT_INVALID_DT, --??????\n" +
                "     EVENT_ID, --??????\n" +
                "     MAIN_BR_ID, --????\n" +
                "     CUST_MGR, --??????\n" +
                "     COM_MAIN_OPT_SCP, --????/???????\n" +
                "     REG_STATE_CODE, --???????\n" +
                "     RGST_CZP, --???????\n" +
                "     RGST_ADDR, --????\n" +
                "     RGST_CAP, --????\n" +
                "     RGST_CAP_CURR_CD, --???????\n" +
                "     CUS_STATUS, --??std_zb_cus_status\n" +
                "     TOTAL_ASSET, --????(?)\n" +
                "     COM_INS_CODE, --??????\n" +
                "     SYS_SRC, --????\n" +
                "     INDUST_RSTRUCT_FLG, --????????\n" +
                "     INDUST_TRAN_FLAG, --????????\n" +
                "     INDUST_STG_TYPE, --????????\n" +
                "     DEFAULT_RATE, --????\n" +
                "     ZFTZPZ_FLAG, --???????\n" +
                "     INVEST_TYPE, --?????\n" +
                "     COM_MRK_AREA, --???\n" +
                "     REG_CUR_TYPE, --??????\n" +
                "     REG_START_DATE, -- ??????????\n" +
                "     LOAN_GREEN_FLAG, --??????STD_ZX_YES_NO\n" +
                "     LOAN_GREEN_TYPE, --??????\n" +
                "     LOAN_GREEN_NAME, --??????\n" +
                "     LEGAL_ID_NO, --??????\n" +
                "     LEGAL_ID_TYPE, --??????\n" +
                "     REG_DFINE, --????????\n" +
                "     IS_DEVE_AREA --???20181031?????????????????\n" +
                "     )\n" +
                "    SELECT /*+ ORDERED  */\n" +
                "     V_DATA_DT                    AS DATA_DT, --????\n" +
                "     T2.OUT_CUS_ID                AS CUS_ID, --???\n" +
                "     T1.CUS_NAME                  AS CUS_NAME, --????\n" +
                "     T1.CUS_ID                    AS LOAN_CUST_ID, --?????\n" +
                "     T3.GUARANTEE_INSURANCE       AS GUARANTEE_INSURANCE, --????\n" +
                "     T1.COM_OPERATOR              AS FIN_LINKMAN, --??????\n" +
                "     T1.FNA_MGR                   AS FIN_CONT_MODE, --?????/???????\n" +
                "     T1.INDUSTRY_NAME             AS INDUSTRY_NAME, --????\n" +
                "     T3.CHANGZHOU_TECH_ENTERPRISE AS CHANGZHOU_TECH_ENTERPRISE, --???\n" +
                "     T1.COM_STR_DATE              AS COM_STR_DATE, --????\n" +
                "     T4.INVT_AMT                  AS INVT_AMT, --????????\n" +
                "     T4.LOAN_CARD                 AS LOAN_CARD, --????????\n" +
                "     T4.INVT_NAME                 AS INVT_NAME, --?????\n" +
                "     T4.CERT_CODE                 AS CERT_CODE_NUM, --???????\n" +
                "     --T4.CERT_TYP AS CERT_TYP, --???????std_zb_cert_typ\n" +
                "     NVL((SELECT T2.STD_CODE\n" +
                "           FROM CMDATA.C_CODE_STD T2\n" +
                "          WHERE T2.CODE_NO = 'ST10008'\n" +
                "            AND T4.CERT_TYP = T2.SRC_CODE),\n" +
                "         T4.CERT_TYP) AS CERT_TYPE, -- ????STD_ZB_CERT_TYP\n" +
                "     T1.FAX_CODE AS FAX_NUM, --????\n" +
                "     T1.COM_EMPLOYEE AS COM_EMPLOYEE, --????\n" +
                "     T1.LOAN_CARD_ID AS LOAN_CARD_NUM, --????(??ECIF)\n" +
                "     -- T1.INPUT_BR_ID AS INPUT_BR_ID, --????\n" +
                "     CASE\n" +
                "       WHEN t15.BRCHNO_V5 IS NOT NULL THEN\n" +
                "        t15.BRCHNO_V7\n" +
                "       ELSE\n" +
                "        T1.INPUT_BR_ID\n" +
                "     END AS INPUT_BR_ID, --????\n" +
                "     T1.INPUT_DATE AS INPUT_DATE, --????\n" +
                "     T1.REG_CODE AS REG_CODE, --?????   --20190306  oyj cms??REG_CODE????ecif????????????????\n" +
                "     T1.REG_TYPE AS RGST_RGST_TYPE, --??????\n" +
                "     T1.REG_AREA_NAME AS REG_AREA_NAME, --????\n" +
                "     T1.EMAIL AS EMAIL, --????\n" +
                "     T5.COM_MRG_NAME AS LEGAL_NAME, --???????\n" +
                "     T5.COM_MRG_CERT_CODE AS LEGAL_CERT_NUM, --????????\n" +
                "     -- T5.COM_MRG_CERT_TYP AS LEGAL_CERT_TYPE, --????????\n" +
                "     NVL((SELECT T2.STD_CODE\n" +
                "           FROM CMDATA.C_CODE_STD T2\n" +
                "          WHERE T2.CODE_NO = 'ST10008'\n" +
                "            AND T5.COM_MRG_CERT_TYP = T2.SRC_CODE),\n" +
                "         T5.COM_MRG_CERT_TYP) AS LEGAL_CERT_TYPE, --????????\n" +
                "     T3.RISK_POOL AS RISK_POOL, --???\n" +
                "     T1.BIG_RISK_CLASS AS BIG_RISK_CLASS, --????\n" +
                "     T6.EVENT_TYPE AS EVENT_TYPE, --??????\n" +
                "     T1.LAST_UPD_ID AS LAST_UPD_ID, --???\n" +
                "     T1.LAST_UPD_DATE AS LAST_UPD_DATE, --????\n" +
                "     T1.COM_STOCK_ID AS STOCK_CD, --????\n" +
                "     /*     CASE\n" +
                "       WHEN TRIM(T11.CUS_TYPE) = '?????' THEN\n" +
                "        '1' -- 1 ???\n" +
                "       WHEN TRIM(T11.CUS_TYPE) = '????' THEN\n" +
                "        '2' --2 ??\n" +
                "       ELSE\n" +
                "        '3' --????\n" +
                "     END AS RELA_CUST_TYPE, --?????*/\n" +
                "     CASE\n" +
                "       WHEN T11.GLR_CARD_TYPE = '1' THEN\n" +
                "        '1' -- 1 ???\n" +
                "       WHEN T11.GLR_CARD_TYPE = '2' THEN\n" +
                "        '2' --2 ??\n" +
                "       ELSE\n" +
                "        '3' --????\n" +
                "     END AS RELA_CUST_TYPE, --?????\n" +
                "     T1.COM_CLL_TYPE AS COM_CLL_TYPE, --????\n" +
                "     T1.COM_CLL_NAME AS COM_CLL_NAME, --????\n" +
                "     T1.REG_STATE_CODE AS AERA_CD, --??????\n" +
                "     T1.BAS_ACC_NO AS BASIC_ACCT, --?????\n" +
                "     T1.BAS_ACC_DATE AS BASIC_ACCT_OPEN_ACCT_DT, --????????\n" +
                "     CASE\n" +
                "       WHEN T1.COM_GRP_MODE IN ('3', '4') THEN\n" +
                "        '1'\n" +
                "       ELSE\n" +
                "        '0'\n" +
                "     END AS GROUP_CORP_IDTFY, --?????? (1?, 0?)\n" +
                "     DECODE(T1.COM_IMP_EXP_FLG, '1', 'Y', '2', 'N') AS EXP_RIGHT_IDTFY, --??????\n" +
                "     --T1.COM_OPT_AERA AS OPER_FIELD_AREA, --??????\n" +
                "     T21.MNG_OPERATE_AREA AS OPER_FIELD_AREA, --???20190306 oyj  cms??COM_OPT_AERA??????ecif??,\n" +
                "     --T1.COM_OPT_OWNER AS OPER_FIELD_PROP, --???????\n" +
                "     DECODE(SUBSTR(T21.MNG_OPERATE_OWNERSHIP, 5),\n" +
                "            '9',\n" +
                "            '3',\n" +
                "            SUBSTR(T21.MNG_OPERATE_OWNERSHIP, 5)) AS OPER_FIELD_PROP, --???20190306 oyj  cms??COM_OPT_OWNER??????ecif???C004 ECF_CODE_STRING C004\n" +
                "     --T1.COM_OPT_ST AS OPER_SITU, --????\n" +
                "     SUBSTR(T21.MNG_SITUATION, 5) AS OPER_SITU, --???20190306 oyj  cms??COM_OPT_ST??????ecif??? C005 CF_CODE_STRING C005\n" +
                "     T1.CERT_CODE AS CERT_CODE, --??????\n" +
                "     --T1.CERT_TYPE AS CERT_TYPE, --??????std_zb_cert_typ\n" +
                "     NVL((SELECT T2.STD_CODE\n" +
                "           FROM CMDATA.C_CODE_STD T2\n" +
                "          WHERE T2.CODE_NO = 'ST10008'\n" +
                "            AND T1.CERT_TYPE = T2.SRC_CODE),\n" +
                "         T1.CERT_TYPE) AS CERT_TYPE, --??????std_zb_cert_typ\n" +
                "     CASE\n" +
                "       WHEN T3.CUS_NAME IS NOT NULL THEN\n" +
                "        NVL(TRIM(T3.TECH_FLAG), '3')\n" +
                "       ELSE\n" +
                "        ''\n" +
                "     END AS TECH_FLAG, --???????\n" +
                "     T1.CUST_MGR AS CUST_MGER, --????\n" +
                "     T1.CUS_TYPE AS CUS_TYPE, --????std_zb_cus_type\n" +
                "     /*     NVL((SELECT T2.STD_CODE\n" +
                "       FROM CMDATA.C_CODE_STD T2\n" +
                "      WHERE T2.CODE_NO = 'ST10003'\n" +
                "        AND T1.CUS_TYPE = T2.SRC_CODE),\n" +
                "     T1.CUS_TYPE) AS CUS_TYPE, --????std_zb_cus_type   */\n" +
                "     T1.COM_CLL_TYPE AS CUST_BELONG_INDUSTRY, --??????\n" +
                "     CASE\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('00', '170') THEN\n" +
                "        '???'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('11', '010') THEN\n" +
                "        'AAA'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('020') THEN\n" +
                "        'AA+'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('12', '030') THEN\n" +
                "        'AA'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('040') THEN\n" +
                "        'AA-'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('050') THEN\n" +
                "        'A+'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('13', '060') THEN\n" +
                "        'A'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('070') THEN\n" +
                "        'A-'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('080') THEN\n" +
                "        'BBB+'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('14', '090') THEN\n" +
                "        'BBB'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('100') THEN\n" +
                "        'BBB-'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('15', '110') THEN\n" +
                "        'BB'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('16', '120') THEN\n" +
                "        'B'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('17', '130') THEN\n" +
                "        'CCC'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('18', '140') THEN\n" +
                "        'CC'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('19', '150') THEN\n" +
                "        'C'\n" +
                "       WHEN T1.COM_CRD_GRADE IN ('160') THEN\n" +
                "        'D'\n" +
                "     END AS CRDT_RATING, --??????\n" +
                "     T1.RISK_DES AS RISK_DES, --????????\n" +
                "     T1.COM_HOLD_TYPE AS HOLD_TYPE, --????\n" +
                "     T1.PHONE AS CONT_TEL, --????\n" +
                "     T3.PRIVATE_ENTERPRISE AS PRIVATE_ENTERPRISE, --??\n" +
                "     T1.COM_SCALE AS CORP_SIZE, --????\n" +
                "     T1.COM_STR_DATE AS CORP_RGST_FDG_DAY, --???????\n" +
                "     T3.ISRH AS ISRH, --????\n" +
                "     T9.BLACK_DATE AS BLACK_DATE, --??????\n" +
                "     T9.BLACK_REASON AS BLACK_REASON, --??????\n" +
                "     T1.TOTAL_ASSET AS LAST_YEAREND_TOTAL_ASSET, --??????\n" +
                "     DECODE(T1.COM_MRK_FLG, '1', 'Y', '2', 'N') AS LIST_CORP_IDTFY, --??????\n" +
                "     T1.COM_CITY_SUBITEM AS COM_CITY_SUBITEM, --??????std_zb_citytown\n" +
                "     T1.COM_CITY_FLG AS FARM_TYPE, --????\n" +
                "     T3.PROVINCE_TECH_ENTERPRISE AS PROVINCE_TECH_ENTERPRISE, --???\n" +
                "     T1.ACU_ADDR AS ACU_ADDR, --??????\n" +
                "     --T1.PAID_CAP_CUR_TYPE AS RECV_DCURR_TYP, --??????\n" +
                "     NVL((SELECT T2.STD_CODE\n" +
                "           FROM CMDATA.C_CODE_STD T2\n" +
                "          WHERE T2.CODE_NO = 'ST0003'\n" +
                "            AND SUBSTR(T1.PAID_CAP_CUR_TYPE, 5) = T2.SRC_CODE),\n" +
                "         T1.PAID_CAP_CUR_TYPE) AS RECV_DCURR_TYP, --??????\n" +
                "     T1.PAID_CAP_AMT AS RECV_CAP_AMT, --??????\n" +
                "     T3.ISTYPEA AS ISTYPEA, --??a??????\n" +
                "     T1.HOME_FARM AS HOME_FARM, --??????std_zx_yes_no\n" +
                "     T1.COM_INIT_LOAN_DATE AS FIRST_CRDT_RELA_DT, --??????????\n" +
                "     CASE\n" +
                "       WHEN NVL(T7.CRD_LMT_AMT, 0) > 0 THEN\n" +
                "        '1'\n" +
                "       ELSE\n" +
                "        '0'\n" +
                "     END CREDIT_LIMIT_FLAG, --??????\n" +
                "     --T1.MNG_BR_ID AS MNG_BR_ID, --??????\n" +
                "     CASE\n" +
                "       WHEN t18.BRCHNO_V5 IS NOT NULL THEN\n" +
                "        t18.BRCHNO_V7\n" +
                "       ELSE\n" +
                "        T1.MNG_BR_ID\n" +
                "     END AS MNG_BR_ID, --??????\n" +
                "     T1.GRP_NO AS GROUP_NO, --?????\n" +
                "     T10.GRP_NAME AS GROUP_NAME, --??????\n" +
                "     T3.CZ_AREA AS CZ_AREA, --????std_zb_cz_area\n" +
                "     T1.SALE_ASS AS SALE_ASS, --???(?)\n" +
                "     T1.COM_CRD_GRADE AS COM_CRD_GRADE, --????(??)std_zb_credit_grade\n" +
                "     T1.COM_OUT_CRD_GRADE AS COM_OUT_CRD_GRADE, --????(??)std_zb_credit_grade\n" +
                "     T1.COM_CRD_DT AS COM_CRD_DT, --??????\n" +
                "     T3.ONENUCLEAR_EIGHTGARDEN AS ONENUCLEAR_EIGHTGARDEN, --????\n" +
                "     T1.POST_CODE AS ZIP_CD, --????\n" +
                "     --T1.COM_INS_REG_DATE AS CERT_EFFECT_DT, --??????\n" +
                "     T21.CERT_ISSUE_DATE AS CERT_EFFECT_DT, --???20190306 oyj ????cms COM_INS_REG_DATE???????????-??????????ecif?????????????\n" +
                "     --T1.COM_INS_EXP_DATE AS CERT_INVALID_DT, --??????\n" +
                "     T21.CERT_EXPD_DATE AS CERT_INVALID_DT, ----???20190306 oyj ????cms COM_INS_EXP_DATE???????????-??????????ecif?????????????\n" +
                "     T6.EVENT_ID        AS EVENT_ID, --??????\n" +
                "     --T1.MAIN_BR_ID AS MAIN_BR_ID, --????\n" +
                "     CASE\n" +
                "       WHEN t17.BRCHNO_V5 IS NOT NULL THEN\n" +
                "        t17.BRCHNO_V7\n" +
                "       ELSE\n" +
                "        T1.MAIN_BR_ID\n" +
                "     END AS MAIN_BR_ID, --????\n" +
                "     T1.CUST_MGR AS CUST_MGR, --??????\n" +
                "     T1.COM_MAIN_OPT_SCP AS COM_MAIN_OPT_SCP, --????/???????\n" +
                "     T1.REG_STATE_CODE AS REG_STATE_CODE, --???????\n" +
                "     T1.COM_COUNTRY AS RGST_CZP, --???????\n" +
                "     T1.REG_ADDR AS RGST_ADDR, --????\n" +
                "     T1.REG_CAP_AMT AS RGST_CAP, --????\n" +
                "     -- T1.PAID_CAP_CUR_TYPE AS RGST_CAP_CURR_CD, --???????\n" +
                "     NVL((SELECT T2.STD_CODE\n" +
                "           FROM CMDATA.C_CODE_STD T2\n" +
                "          WHERE T2.CODE_NO = 'ST0003'\n" +
                "            AND SUBSTR(T1.PAID_CAP_CUR_TYPE, 5) = T2.SRC_CODE),\n" +
                "         T1.PAID_CAP_CUR_TYPE) AS RGST_CAP_CURR_CD, --???????\n" +
                "     T1.CUS_STATUS AS CUS_STATUS, --??std_zb_cus_status\n" +
                "     T1.TOTAL_ASSET AS TOTAL_ASSET, --????(?)\n" +
                "     --T1.COM_INS_CODE AS COM_INS_CODE, --??????\n" +
                "     T21.COM_INS_CODE AS COM_INS_CODE, --???20190306 oyj cms??COM_INS_CODE??????ecif??\n" +
                "     'CMS' AS SYS_SRC, --????\n" +
                "     T1.ADJUST_TYPE AS INDUST_RSTRUCT_FLG, --????????\n" +
                "     DECODE(TRIM(T1.UPGRADE_SIGN), '1', 'Y', 'N') AS INDUST_TRAN_FLAG, --????????\n" +
                "     T1.INDUSTRY_TYPE AS INDUST_STG_TYPE, --????????\n" +
                "     T1.AVERAGE_LOSS_RATE AS DEFAULT_RATE, --????\n" +
                "     T1.ZFTZPZ_FLAG AS ZFTZPZ_FLAG, -- ???????\n" +
                "     T1.INVEST_TYPE AS INVEST_TYPE, --?????\n" +
                "     T1.COM_MRK_AREA AS COM_MRK_AREA, --???\n" +
                "     -- T1.REG_CUR_TYPE AS REG_CUR_TYPE, --??????\n" +
                "     NVL((SELECT T2.STD_CODE\n" +
                "           FROM CMDATA.C_CODE_STD T2\n" +
                "          WHERE T2.CODE_NO = 'ST0003'\n" +
                "            AND SUBSTR(T1.REG_CUR_TYPE, 5) = T2.SRC_CODE),\n" +
                "         T1.REG_CUR_TYPE) AS REG_CUR_TYPE, --??????\n" +
                "     T1.REG_START_DATE AS REG_START_DATE, -- ??????????\n" +
                "     T1.LOAN_GREEN_FLAG as LOAN_GREEN_FLAG, --??????STD_ZX_YES_NO\n" +
                "     T1.LOAN_GREEN_TYPE as LOAN_GREEN_TYPE, --??????\n" +
                "     T1.LOAN_GREEN_NAME AS LOAN_GREEN_NAME, --??????\n" +
                "     t19.cert_no as LEGAL_ID_NO, --??????\n" +
                "     t19.cert_type as LEGAL_ID_TYPE, --??????\n" +
                "     T20.CNNAME AS CNNAME, --T1.REG_DFINE ?????\n" +
                "     T1.IS_DEVE_AREA AS IS_DEVE_AREA --???20181031?????????????????\n" +
                "      FROM JNCREDIT66.CUS_COM@cms T1\n" +
                "     INNER JOIN JNCREDIT66.CUS_BASE@cms T2\n" +
                "        ON T1.CUS_ID = T2.CUS_ID\n" +
                "    /*AND T2.START_DT <= V_DATA_DT\n" +
                "    AND T2.END_DT > V_DATA_DT\n" +
                "    AND T2.DEL_IND = ' '*/\n" +
                "      LEFT JOIN JNCREDIT66.CUS_COM_TECHNOLOGY@cms T3\n" +
                "    --ON T1.CUS_ID = T3.CUS_ID\n" +
                "        ON T1.CUS_NAME = T3.CUS_NAME\n" +
                "    /*AND T3.START_DT <= V_DATA_DT\n" +
                "    AND T3.END_DT > V_DATA_DT*/\n" +
                "      LEFT JOIN (SELECT T.CUS_ID,\n" +
                "                        MAX(T.LOAN_CARD) AS LOAN_CARD,\n" +
                "                        MAX(T.INVT_NAME) AS INVT_NAME,\n" +
                "                        MAX(T.CERT_CODE) AS CERT_CODE,\n" +
                "                        MAX(T.CERT_TYP) AS CERT_TYP,\n" +
                "                        SUM(T.INVT_AMT) AS INVT_AMT\n" +
                "                   FROM JNCREDIT66.CUS_COM_REL_APITAL@cms T\n" +
                "                 /*WHERE T.START_DT <= V_DATA_DT\n" +
                "                 AND T.END_DT > V_DATA_DT*/\n" +
                "                  GROUP BY T.CUS_ID) T4\n" +
                "        ON T1.CUS_ID = T4.CUS_ID\n" +
                "      LEFT JOIN (SELECT T8.CUS_ID,\n" +
                "                        T8.CUS_ID_REL, --??????\n" +
                "                        T8.COM_MRG_NAME, --????\n" +
                "                        T8.COM_MRG_CERT_TYP, --??????\n" +
                "                        T8.COM_MRG_CERT_CODE,\n" +
                "                        T8.COM_MRG_MPHN1, --????\n" +
                "                        ROW_NUMBER() OVER(PARTITION BY CUS_ID ORDER BY LAST_UPD_DATE DESC, CUS_ID_REL) RN\n" +
                "                   FROM JNCREDIT66.CUS_COM_MANAGER@cms T8 --???????????\n" +
                "                  WHERE /*T8.START_DT <= V_DATA_DT\n" +
                "                                                                                                                                           AND T8.END_DT > V_DATA_DT\n" +
                "                                                                                                                                           AND*/\n" +
                "                  T8.COM_MRG_TYP = '02') T5\n" +
                "        ON T1.CUS_ID = T5.CUS_ID\n" +
                "       AND RN = 1\n" +
                "      LEFT JOIN JNCREDIT66.PSP_EVENT@cms T6\n" +
                "        ON T1.CUS_ID = T6.CUS_ID\n" +
                "    /*AND T6.START_DT <= V_DATA_DT\n" +
                "    AND T6.END_DT > V_DATA_DT*/\n" +
                "    /*      LEFT JOIN (SELECT D.CERT_CODE,\n" +
                "                     D.CUS_TYPE,\n" +
                "                     ROW_NUMBER() OVER(PARTITION BY D.CERT_CODE ORDER BY DATA_DATE DESC) NM\n" +
                "                FROM JNCREDIT66.CUS_BANK D --???????\n" +
                "              UNION -- ALL 20170918  ??\n" +
                "              SELECT --D.CUS_ID,\n" +
                "               D.CERT_CODE,\n" +
                "               D.CUS_TYPE,\n" +
                "               ROW_NUMBER() OVER(PARTITION BY D.CERT_CODE ORDER BY DATA_DATE DESC) NM\n" +
                "                FROM JNCREDIT66.CUS_MBANK_REL D --???????\n" +
                "              ) T11\n" +
                "     ON T11.CERT_CODE = T2.CERT_CODE\n" +
                "    AND T11.NM = 1*/\n" +
                "      LEFT JOIN (SELECT T1.CARD_NO, '1' AS GLR_CARD_TYPE\n" +
                "                   FROM OMDATA.RTS_T01_RELEVANCYNATURE T1 -- ?????\n" +
                "                 UNION\n" +
                "                 SELECT T1.CARD_NO, '2' AS GLR_CARD_TYPE\n" +
                "                   FROM OMDATA.RTS_T01_RELEVANCYCORP T1) T11\n" +
                "        ON T11.CARD_NO = T2.CERT_CODE\n" +
                "      LEFT JOIN (SELECT *\n" +
                "                   FROM (SELECT A.CERT_CODE,\n" +
                "                                TO_DATE(A.BLACK_DATE, 'YYYY-MM-DD') AS BLACK_DATE,\n" +
                "                                A.BLACK_REASON,\n" +
                "                                ROW_NUMBER() OVER(PARTITION BY A.CERT_CODE ORDER BY TO_DATE(A.BLACK_DATE, 'YYYY-MM-DD') DESC) AS MARK\n" +
                "                           FROM JNCREDIT66.CUS_BLK@cms A\n" +
                "                          WHERE A.CUS_TYPE = '110'\n" +
                "                         /*AND A.START_DT <= V_DATA_DT\n" +
                "                         AND A.END_DT > V_DATA_DT*/\n" +
                "                         ) A3\n" +
                "                  WHERE A3.MARK = '1') T9 --???\n" +
                "        ON T1.CUS_ID = T9.CERT_CODE\n" +
                "      LEFT JOIN (SELECT T.CUS_ID, SUM(T.CRD_LMT_AMT) CRD_LMT_AMT\n" +
                "                   FROM JNCREDIT66.LMT_CONT@cms T --????\n" +
                "                 /*WHERE T.START_DT <= V_DATA_DT\n" +
                "                 AND T.END_DT > V_DATA_DT*/\n" +
                "                  GROUP BY T.CUS_ID) T7\n" +
                "        ON T1.CUS_ID = T7.CUS_ID\n" +
                "      LEFT JOIN JNCREDIT66.CUS_GRP_INFO@cms T10\n" +
                "        ON /*T10.START_DT <= V_DATA_DT\n" +
                "               AND T10.END_DT > V_DATA_DT\n" +
                "               AND T10.DEL_IND = ' '\n" +
                "               AND*/\n" +
                "     TRIM(T10.GRP_NO) = TRIM(T1.GRP_NO)\n" +
                "      LEFT JOIN CMDATA.c_code_brch t15\n" +
                "        ON T1.INPUT_BR_ID = T15.BRCHNO_V5\n" +
                "      LEFT JOIN CMDATA.c_code_brch t17\n" +
                "        ON T1.MAIN_BR_ID = T17.BRCHNO_V5\n" +
                "      LEFT JOIN CMDATA.c_code_brch t18\n" +
                "        ON T1.MNG_BR_ID = T18.BRCHNO_V5\n" +
                "    /****************************************hou******************************************/\n" +
                "      LEFT JOIN (select party_id, cert_type, cert_no, ecif_cust_no\n" +
                "                   from (select b1.party_id,\n" +
                "                                b2.cert_type,\n" +
                "                                b2.cert_no,\n" +
                "                                b3.ecif_cust_no,\n" +
                "                                --?????????????????????????\n" +
                "                                row_number() over(partition by b1.party_id order by b1.created_ts desc, b2.cert_type, b2.created_ts desc, b2.party_resolve_id) rw\n" +
                "                           from omdata.ECF_T02_C_PAR_TO_PAR_REL b1\n" +
                "                           left join omdata.ecf_t01_p_cert_info b2\n" +
                "                             on b1.relation_id = b2.party_id\n" +
                "                            and b2.pre_cert_flag = '1' --????\n" +
                "                            and b2.start_dt <= V_DATA_DT\n" +
                "                            and b2.end_dt > V_DATA_DT\n" +
                "                           left join omdata.ecf_t01_c_cust_info b3\n" +
                "                             on b1.party_id = b3.party_id\n" +
                "                            and b3.start_dt <= V_DATA_DT\n" +
                "                            and b3.end_dt > V_DATA_DT\n" +
                "                            and b3.del_ind <> 'D'\n" +
                "                          where b1.relation_type = 'A0070200400' --??\n" +
                "                            and b1.start_dt <= V_DATA_DT\n" +
                "                            and b1.end_dt > V_DATA_DT)\n" +
                "                  where rw = 1) t19\n" +
                "        on T2.OUT_CUS_ID = t19.ecif_cust_no\n" +
                "      LEFT JOIN JNCREDIT66.S_DIC@cms T20\n" +
                "        ON T1.REG_DFINE = T20.ENNAME\n" +
                "       AND T20.OPTTYPE = 'STD_ZB_REG_DFINE'\n" +
                "    -----------???20190306 oyj ?????????????????????---\n" +
                "      LEFT JOIN (SELECT T1.ECIF_CUST_NO,\n" +
                "                        T2.CERT_NO, --????\n" +
                "                        T2.CERT_ISSUE_DATE, --??????????\n" +
                "                        T2.CERT_EXPD_DATE, --????????????\n" +
                "                        T3.CERT_NO COM_INS_CODE, --??????\n" +
                "                        T1.MNG_OPERATE_AREA, --??????(???)\n" +
                "                        T1.MNG_OPERATE_OWNERSHIP, --??????? C004 ECF_CODE_STRING C004\n" +
                "                        T1.MNG_SITUATION --???? C005 CF_CODE_STRING C005\n" +
                "                   FROM OMDATA.ECF_T01_C_CUST_INFO T1 --????????\n" +
                "                 \n" +
                "                   LEFT JOIN OMDATA.ECF_T01_C_CERT_INFO T2 --????????\n" +
                "                     ON T1.PARTY_ID = T2.PARTY_ID\n" +
                "                    AND T2.PRE_CERT_FLAG = '1' --?????\n" +
                "                    AND T2.START_DT <= V_DATA_DT\n" +
                "                    AND T2.END_DT > V_DATA_DT\n" +
                "                    AND T2.DEL_IND = ' '\n" +
                "                 \n" +
                "                   LEFT JOIN OMDATA.ECF_T01_C_CERT_INFO T3 --????????\n" +
                "                     ON T1.PARTY_ID = T3.PARTY_ID\n" +
                "                    AND T3.START_DT <= V_DATA_DT\n" +
                "                    AND T3.END_DT > V_DATA_DT\n" +
                "                    AND T3.DEL_IND = ' '\n" +
                "                    AND T3.CERT_TYPE = 'A00120600' --20600???????\n" +
                "                 ) T21\n" +
                "        ON T2.OUT_CUS_ID = T21.ECIF_CUST_NO";
        SqlParserDruid.opSqlTargetResourceByDruid(sql2, "");

    }
}
