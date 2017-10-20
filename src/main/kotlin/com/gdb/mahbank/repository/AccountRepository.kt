package com.gdb.mahbank.repository

import com.gdb.mahbank.model.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository("accountRepository")
interface AccountRepository : CrudRepository<Account, Long>