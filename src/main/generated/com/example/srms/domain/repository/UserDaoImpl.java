package com.example.srms.domain.repository;

/** */
@org.springframework.stereotype.Repository()
@javax.annotation.Generated(value = { "Doma", "2.19.0" }, date = "2019-02-27T23:39:02.431+0900")
public class UserDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.example.srms.domain.repository.UserDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.19.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.example.srms.domain.repository.UserDao.class, "selectByUserId", java.lang.String.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public UserDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public com.example.srms.domain.model.UserInfoEntity selectByUserId(java.lang.String userId) {
        entering("com.example.srms.domain.repository.UserDaoImpl", "selectByUserId", userId);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/example/srms/domain/repository/UserDao/selectByUserId.sql");
            __query.setEntityType(com.example.srms.domain.model._UserInfoEntity.getSingletonInternal());
            __query.addParameter("userId", java.lang.String.class, userId);
            __query.setCallerClassName("com.example.srms.domain.repository.UserDaoImpl");
            __query.setCallerMethodName("selectByUserId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<com.example.srms.domain.model.UserInfoEntity> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<com.example.srms.domain.model.UserInfoEntity>(com.example.srms.domain.model._UserInfoEntity.getSingletonInternal()));
            com.example.srms.domain.model.UserInfoEntity __result = __command.execute();
            __query.complete();
            exiting("com.example.srms.domain.repository.UserDaoImpl", "selectByUserId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.example.srms.domain.repository.UserDaoImpl", "selectByUserId", __e);
            throw __e;
        }
    }

}
